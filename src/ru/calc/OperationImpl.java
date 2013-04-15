package ru.calc;

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
    public void operat(String[] args){
        System.out.print("Expression: ");
        //BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        //String inputs = "- 2 + 3 * ( 4 - 1 )";
       // Scanner in = new Scanner(inputs);
        LinkedList<String> st = new LinkedList<String>();
        for (String arg : args) {
            System.out.println(arg);
            st.add(arg);

        }
        LinkedList<String> sstr = new LinkedList<String>();

        TreeImpl tree = new TreeImpl();

        TreeNode first = new TreeNode();
        TreeNode second = new TreeNode();
        TreeNode thrid = new TreeNode();
        TreeNode four = new TreeNode();
        TreeNode five = new TreeNode();
        four.setElement("4");
        five.setElement("5");
        thrid.setElement("+");
        thrid.setLeft(four);   thrid.setRight(five);
        four.setParent(thrid);  five.setParent(thrid);
        four.setRight(null);four.setLeft(null);
        five.setRight(null);five.setLeft(null);
        second.setElement("2");
        second.setRight(null);second.setLeft(null);
        first.setElement("*");
        first.setRight(thrid);first.setLeft(second);
        thrid.setParent(first);
        second.setParent(first);
      //  tree.addNode(first);
      //  tree.addNode(second);
      //  tree.addNode(thrid);
      //  tree.addNode(four);
      //  tree.addNode(five);

      //  System.out.println(tree.get(5).getParent().getParent().getLeft().getElement());

        //Распарсили строчку. каждый символ по отдельности!
        Pattern three = Pattern.compile("\\s*(\\d+\\.?\\d*(e[+-]?)?\\d*\\s*)|[\\- + * ^ / \\( \\)]", Pattern.CASE_INSENSITIVE);
       // Pattern three2 = Pattern.compile("\\s*\\(\\s*(.*)\\s*\\)\\s([^)]*)$", Pattern.CASE_INSENSITIVE);
        Pattern operand = Pattern.compile("(\\- +)(\\* / \\( \\))",Pattern.CASE_INSENSITIVE);
        Pattern numeric = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);

        Matcher matcher = three.matcher(st.get(0));
      //  Matcher matcherOperand = operand.matcher(st.get(0));

        while (matcher.find()){
            int startnumb = matcher.start();
            int endnumb= matcher.end();
            String s = st.get(0).substring(startnumb, endnumb);
            sstr.add(s);
              }

        int previous =0;
        LinkedList<String> expr = new LinkedList<String>();
        char[] chars = st.get(0).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character aChar = chars[i];
            expr.add(aChar.toString());
            Matcher matcherNumb = three.matcher(aChar.toString());
            if (matcherNumb.matches()){
                if ((i-previous)>1){
                    previous=i;
                }
            }
        }
        System.out.println(sstr);
        tree = createTree(sstr);

      /*  for (int i = 0; i<sstr.size(); i++) {
             Matcher numb = numeric.matcher(sstr.get(i));
            Matcher ololo = operand.matcher(sstr.get(i));
            System.out.println(ololo.groupCount());

            if (numb.find())
            {
                tree.addNode(new TreeNode(sstr.get(i),null));
                System.out.println(sstr.get(i));
            }
            else System.out.println(sstr.get(i));


        } */
      //  System.out.println(tree.get(3).getParent().getLeft().getElement());
        Operators operators;
        System.out.println(tree);
        for (int  i =0 ; i<tree.size(); i++){
           System.out.println(tree.get(i).getElement()+" nom "+ i);
            if (tree.get(i).getParent()==null){
                System.out.println(tree.get(i).getElement());

            }
        }
       System.out.println(tree.get(4).getParent().getParent().getLeft().getElement());
       //System.out.println(tree.get(1).getParent().getRight().getRight().getElement());
        getResult(tree);
}

    public TreeImpl createTree(LinkedList input){
        TreeImpl tree = new TreeImpl();
        TreeNode oldParent = new TreeNode();
        TreeNode parent= new TreeNode();
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        Pattern hightPriority = Pattern.compile("[\\* / ]", Pattern.CASE_INSENSITIVE);
        Pattern lowPriority = Pattern.compile("[-+]", Pattern.CASE_INSENSITIVE);
        int previous = 0;
        for (int i =0; i<input.size(); i++){
            Matcher match = hightPriority.matcher(input.get(i).toString());
            Matcher low = lowPriority.matcher(input.get(i).toString());
        if (match.find()){
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
                left.setParent(parent);
                tree.addNode(parent);
                tree.addNode(left);
                if (i>(input.size()/2)){
                    right = new TreeNode(Double.valueOf(input.get(i-1).toString()),null,null,parent);
                    parent.setRight(right);
                    tree.addNode(right);
                }
            }
        }

        }
        return tree;

    }
    public void getResult(TreeImpl tree){
          //System.out.println(tree.root().getElement());
        for (TreeNode node: tree){
            if (node.getParent()==null){System.out.println("isRoot");
                if (node.getRight().getElement()!=null){
                    System.out.println(node.getRight().getElement());
                }

            }
        }
    }
enum Operators {
    SUM{
       public String toString(){
           return "+";
       }
    },
    MULTIPL{
        public String toString(){
            return "*";
        }
    },
    SUB,
    DIV;


}
}
