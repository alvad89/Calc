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
        List<Character> action = new ArrayList<Character>();
        exprOne = 0;
        exprTwo = 0;
        try {
            while((all=inp.readLine()) !=null && !all.equals("")){


                for (String a: all.split("[+ * \\- / ]")){
                     if (a.length()>0)expr.add(Double.valueOf(a));
                }
                System.out.println(expr);
                for (String a: all.split("[0-9]")){
                    if(a.length()>0) action.add(a.charAt(0));

                }
                //Сначала выполним поиск операторов умножения и деления
                if(all.contains("*") || all.contains("/")){
                    for(int i=0; i<action.size();i++){
                       switch (action.get(i)){
                           case '*': if (exprOne!=0) exprOne=multiply(exprOne,expr.get(i));
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
                System.out.println(expr);
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
        }


    }
    private double exprTwo, exprOne;





    @Override
    public Double sum(double a, double b) {
        return a+b;
    }

    @Override
    public Double multiply(double a, double b) {
        System.out.println(a*b);
        return a*b;
    }

    @Override
    public Double sub(double a, double b) {
        return a-b;
    }

    @Override
    public Double div(double a, double b) {
        System.out.println(a/b);
        return a/b;
    }
}