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
        System.out.println(tree.size());
        System.out.println(tree);

      //  System.out.println(tree.get(5).getParent().getParent().getLeft().getElement());

        //Распарсили строчку. каждый символ по отдельности!
        Pattern three = Pattern.compile("\\s*(\\d+\\.?\\d*(e[+-]?)?\\d*\\s*)|[\\- + * ^ / \\( \\)]", Pattern.CASE_INSENSITIVE);
       // Pattern three2 = Pattern.compile("\\s*\\(\\s*(.*)\\s*\\)\\s([^)]*)$", Pattern.CASE_INSENSITIVE);
       // Pattern operand = Pattern.compile("[\\- + * / \\( \\)]",Pattern.CASE_INSENSITIVE);
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
        System.out.println(sstr.indexOf("("));
        TreeNode parent = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        for (int i = 0; i<sstr.size(); i++) {
             Matcher numb = numeric.matcher(sstr.get(i));
            //System.out.println(aSstr);
            if (numb.find())
            {
                tree.addNode(new TreeNode(sstr.get(i),null));
                System.out.println(sstr.get(i));
            }
            else System.out.println(sstr.get(i));
            /*switch (iter.next().charAt(0)){
                case '+':
                        System.out.println("node");
                    break;
                case '-':
                        System.out.println("node");
                    break;
                case '*':
                        System.out.println("node");
                    break;
                case '/':
                        System.out.println("node");
                    break;
                default: System.out.println("leaf");
                    break;
            } */

        }
        System.out.println(tree);




      /*  try {

public class OperationImpl implements Operation{
    public void operat(String[] args){
        System.out.println("Enter expression:");
        //BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        List<String> str = new ArrayList<String>();
        String all = null;
        for (int i=0; i<args.length; i++){
            System.out.print(args[i]);
            str.add(args[i]);
        }
        Pattern numbers = Pattern.compile("");
      //  System.out.println(args[1]);
        Operators op = Operators.MULTIPL;

        List<Double> expr = new ArrayList<Double>();
        List<Character> action = new ArrayList<Character>();
        exprOne = 0;
        /*
        try {

            while((all=inp.readLine()) !=null && !all.equals("")){

                //сохраним все цифры в массив по порядку
                for (String a: all.split("[+ * \\- / ( )]")){
                     if (a.length()>0)expr.add(Double.valueOf(a));
                }
                //сохраним все действия по порядку
                for (String a: all.split("[0-9]")){
                    if(a.length()>0) action.add(a.charAt(0));

                }
                //Сначала выполним поиск операторов умножения и деления
                if(all.contains("*") || all.contains("/")){
                    for(int i=0; i<action.size();i++){
                       switch (action.get(i)){
                           case '*': if (exprOne!=0) exprOne=multiply(exprOne,expr.get(i));
                               //если первым в вырожении идёт отрицательное число(сложение работает, вычитание не очень)
                               else {if (action.size()==expr.size()){exprOne = multiply(expr.get(i-1), expr.get(i));
                               expr.remove(i);
                               expr.remove(i-1);
                               expr.add(i-1,exprOne);} else {
                               exprOne = multiply(expr.get(i), expr.get(i+1));
                               expr.remove(i+1);
                               expr.remove(i);
                               expr.add(i,exprOne);        }
                           } break;
                           case '/': if (exprOne!=0) exprOne=div(exprOne,expr.get(i));
                           else {if (action.size()==expr.size()){exprOne = div(expr.get(i-1), expr.get(i));
                               expr.remove(i);
                               expr.remove(i-1);
                               expr.add(i-1,exprOne);} else {
                               exprOne = div(expr.get(i), expr.get(i+1));
                               expr.remove(i+1);
                               expr.remove(i);
                               expr.add(i,exprOne);        }
                           } break;
                           default: break;
                       }
                    }
                }

                if (all.contains("+") || all.contains("-")){
                    for(int i=0; i<action.size();i++){
                        switch (action.get(i)){
                            case '+': if (exprOne!=0) exprOne=sum(exprOne,expr.get(i));
                            else {exprOne = sum(expr.get(i), expr.get(i+1));
                                expr.remove(i+1);
                                expr.remove(i);
                                expr.add(i,exprOne);}
                                break;
                            case '-': if (exprOne!=0) exprOne=sub(exprOne, expr.get(i));
                            else {exprOne = sub(expr.get(i), expr.get(i+1));
                                expr.remove(i+1);
                                expr.remove(i);
                                expr.add(i,exprOne);}
                                break;
                            default: break;
                        }
                    }
                }
                System.out.println(exprOne);
                exprOne =0;
                expr.clear();
                action.clear();

            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

        } */



    }
    private double exprOne;
    public boolean isOperand(char s){
        switch (s){
            case '0':return true;
            case '1':return true;
            case '2':return true;
            case '3':return true;
            case '4':return true;
            case '5':return true;
            case '6':return true;
            case '7':return true;
            case '8':return true;
            case '9':return true;
        }
        return false;
    }

 
}
enum Operators {
    SUM,
    MULTIPL,
    SUB,
    DIV,
}
