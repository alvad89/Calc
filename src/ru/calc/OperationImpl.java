package ru.calc;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * User: a1
 * Date: 29.03.13
 * Time: 8:56
 * To change this template use File | Settings | File Templates.
 */
public class OperationImpl implements Operation{
    public void operat(){
        System.out.println("Enter expression:");
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String all = null;
        List<Double> expr = new ArrayList<Double>();
        exprOne = 0;
        exprTwo =0;
        action = ' ';
        try {
            while((all=inp.readLine()) !=null && !all.equals("")){
                if(all.contains("(")){System.out.println("Crj,rf!!!");}
                for (String a: all.split("[+ * \\- / ]")){
                    expr.add(Double.valueOf(a));
                    System.out.println(a);
                }
                System.out.println(expr);
               // String s = all.substring(0, all.indexOf(" "));
               // System.out.println(s);
               // exprOne = Double.parseDouble(s);
               // s = all.substring(all.indexOf(" ")+1, all.lastIndexOf(" "));
               // action = s.charAt(0);
               // System.out.println(all.substring(all.indexOf(" ")+1, all.lastIndexOf(" ")));
               // exprTwo = Double.parseDouble(all.substring(all.lastIndexOf(" ")));
                switch (action){
                    case '+': System.out.println("summm"); break;
                    case '-': System.out.println("dev"); break;
                    default: break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
    private double exprTwo, exprOne, exprThree, exprFour;
    private char action;




    @Override
    public void sum(double a, double b) {
        System.out.println(a+b);
    }

    @Override
    public void multiply(double a, double b) {
        System.out.println(a*b);
    }

    @Override
    public void sub(double a, double b) {
       if (a >= b) System.out.println(a/b);
        else System.out.println(b/a);
    }

    @Override
    public void div(double a, double b) {

    }
}
