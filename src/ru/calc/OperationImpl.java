package ru.calc;

import ru.calc.ru.operator.Div;
import ru.calc.ru.operator.Mult;
import ru.calc.ru.operator.Sub;
import ru.calc.ru.operator.Summ;

import java.util.*;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Выражение со скобками не поддерживается, не правильно считает если первое в выражении отрицательное число
 * User: a1
 * Date: 29.03.13
 * Time: 8:56
 * To change this template use File | Settings | File Templates.
 */

public class OperationImpl{
    private LinkedList<Operation> oper = null;
    private Pattern op = Pattern.compile("[\\- + * ^ /]", Pattern.CASE_INSENSITIVE);
    TreeNode root;
    public OperationImpl(){
        super();
        oper = new LinkedList<Operation>();
        oper.add(new Summ());
        oper.add(new Sub());
        oper.add(new Mult());

        oper.add(new Div());
    }
    public void operat(String[] args){
        System.out.print("Expression: ");
        //BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        //String inputs = "- 2 + 3 * ( 4 - 1 )";
        //Scanner in = new Scanner(inputs);
        LinkedList<String> st = new LinkedList<String>();
        for (String arg : args) {
            System.out.println(arg);
            st.add(arg);

        }
        LinkedList<String> sstr = new LinkedList<String>();
        TreeImpl tree = new TreeImpl();

    /*    TreeNode first = new TreeNode('-',null);
        TreeNode second = new TreeNode("6",null, null,first);
        TreeNode thrid = new TreeNode('/', first);
        TreeNode four = new TreeNode("12",null,null,thrid);
        TreeNode five = new TreeNode("4",null,null,thrid);
        first.setLeft(second);first.setRight(thrid);
        thrid.setLeft(four);thrid.setRight(five);
        tree.addNode(first);
        tree.addNode(second);
        tree.addNode(thrid);
        tree.addNode(four);
        tree.addNode(five); */


        //Распарсили строчку. каждый символ по отдельности!
        Pattern three = Pattern.compile("\\s*(\\d+\\.?\\d*(e[+-]?)?\\d*\\s*)|[\\- + * ^ / \\( \\)]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = three.matcher(st.get(0));

        while (matcher.find()){
            int startnumb = matcher.start();
            int endnumb= matcher.end();
            String s = st.get(0).substring(startnumb, endnumb);
            sstr.add(s);
              }

        System.out.println(createOPN(sstr));
        tree = createTree(createOPN(sstr));


      //System.out.println(tree);
        for (int  i =0 ; i<tree.size(); i++){
           System.out.println(tree.get(i).getElement()+" nom "+ i);
        }
      // System.out.println(tree.get(4).getParent().getParent().getLeft().getElement());
       //System.out.println(tree.get(1).getParent().getRight().getRight().getElement());

        root = tree.getRoot();
        System.out.println(getResult(root));
}

    public TreeImpl createTree(LinkedList input){
        TreeImpl tree = new TreeImpl();
        TreeNode parent= new TreeNode(null,null);
        TreeNode root = new TreeNode(input.getLast(),null);
        tree.addNode(root);
        input.removeLast();
        TreeNode left; //= new TreeNode();
        TreeNode right;// = new TreeNode();

        Matcher last = op.matcher(input.getLast().toString());
        if (!last.find()){
            left = new TreeNode(input.getLast().toString(),null,null, root);
            root.setLeft(left);
            tree.addNode(root);
            tree.addNode(left);
            input.removeLast();
        }
            for (int i=input.size()-1; i>=0; i--){
                Matcher match = op.matcher(input.get(i).toString());
                if (match.find()){
                    parent = new TreeNode(input.get(i).toString(),null);
                    if (i==input.size()-1){
                    root.setRight(parent);
                    parent.setParent(root);
                    //tree.addNode(root);
                    }
                    left = new TreeNode(input.get(i-1).toString(),null, null, parent);
                    right = new TreeNode(input.get(i-2).toString(),null,null,parent);
                    parent.setLeft(left); parent.setRight(right);
                    tree.addNode(parent);
                    tree.addNode(left);
                    tree.addNode(right);
                    i = i-2;
                }
                else {
                    left = new TreeNode(input.get(i).toString(),null,null,parent);
                    parent.setLeft(left);
                    tree.addNode(left);
                }

        /*if (match.find()){
            parent = new TreeNode(input.get(i).toString().charAt(0), parent);
            left = new TreeNode(Double.valueOf(input.get(i-1).toString()),null,null, parent);
            right = new TreeNode(Double.valueOf(input.get(i + 1).toString()), null,null, parent);
            parent.setLeft(left);parent.setRight(right);
            tree.addNode(parent);
            previous = i;
            tree.addNode(left);
            tree.addNode(right);
        }else if (low.find()){
            if (parent.getElement()==null){
               parent = new TreeNode(input.get(i).toString(), null);
               if ((i-1)<0)
                left = new TreeNode(Double.valueOf("0"),null, null, parent);
                else left = new TreeNode(Double.valueOf(input.get(i - 1).toString()),null, null, parent);
                //previous = i;
               parent.setLeft(left);
               tree.addNode(parent);
               tree.addNode(left);
            }  else {
                left = new TreeNode(Double.valueOf(input.get(i+1).toString()), null,null, null);
                parent = new TreeNode(input.get(i).toString().charAt(0), left,parent,null);
                tree.get(previous).setParent(parent);
                //parent.setParent(tree.get(previous));
               // left.setParent(parent);
                tree.addNode(parent);
                tree.addNode(left);
                if (i>(input.size()/2)){
                    right = new TreeNode(Double.valueOf(input.get(i-1).toString()),null,null,parent);
                    parent.setRight(right);
                    tree.addNode(right);
                }
            }
        }*/

            }

        return tree;

    }
    public Object getResult(TreeNode tree){
        if (tree.getLeft()==null && tree.getRight()==null){
             return Double.valueOf(tree.getElement().toString());
        }
        else{
           Object left = getResult(tree.getLeft());
           Object right =  getResult(tree.getRight());
            for (Operation anOper : oper) {
                if (anOper.getSymbol().equals(tree.getElement().toString())) {
                    Object o = anOper.evaluate((Double) left, (Double) right);
                    tree.setElement(o);
                    return o;
                }
            }
        }
        return null;
    }
    public LinkedList<String> createOPN(LinkedList<String> str){
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> operator = new LinkedList<String>();
        Iterator operIterat = oper.iterator();
        Pattern numeric = Pattern.compile("[\\- + * ^ / \\( \\)]", Pattern.CASE_INSENSITIVE);
        if (str.get(0).equals("-")){
            str.addFirst("0");
        }
            for (int i=0; i<str.size(); i++){
                Matcher matc = numeric.matcher(str.get(i));
                Matcher matchOper = op.matcher(str.get(i));
                if (matc.find()){

                     if (str.get(i).equals("(")){
                         operator.add(str.get(i));
                     }
                    else if (str.get(i).equals(")")){
                         while (!operator.getLast().equals("(")){
                             result.add(operator.getLast());
                             operator.removeLast();
                         }
                         operator.removeLast();
                     }

                    else if (matchOper.find()){
                         if (operator.isEmpty()) {operator.add(str.get(i));}
                         else if (getPriority(str.get(i))>getPriority(operator.getLast())){
                             operator.add(str.get(i));
                         } else {
                             boolean flag = !operator.isEmpty();
                             while (flag){
                                 if (getPriority(str.get(i))<=getPriority(operator.getLast()))
                                 result.add(operator.getLast());
                                 operator.removeLast();
                                 flag = false;
                             }
                             operator.add(str.get(i));
                         }
                }}
                else {
                    result.add(str.get(i));
                }
            }

        while (operator.size()>0){
            result.add(operator.getLast());
            operator.removeLast();
        }

        return result;
    }
    public int getPriority(String s){
        int i=0;
        Iterator<Operation> operIterat = oper.iterator();
        while (operIterat.hasNext()){
            if (operIterat.next().getSymbol().equals(s)){
                i= operIterat.next().getPriority();
                return i;
            }
        }
        return 0;
    }


}
