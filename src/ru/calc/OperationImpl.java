package ru.calc;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Выражение со скобками не поддерживается, не правильно считает если первое в выражении отрицательное число
 * User: a1
 * Date: 29.03.13
 * Time: 8:56
 * To change this template use File | Settings | File Templates.
 */
public class OperationImpl implements Operation{
    public void operat(){
        System.out.println("Enter expression:");
        //BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String inputs = "- 2 + 3 * ( 4 - 1 )";
        Scanner in = new Scanner(inputs);
        String all = null;
        Pattern pat = Pattern.compile("\\s*([-+]?\\d+\\.?\\d*(e[-+]?)?\\d*\\s*)(.*)", Pattern.CASE_INSENSITIVE);
        System.out.println(in.next(pat));
        Pattern pt = Pattern.compile("\\s*\\(\\s*(.*)\\s*\\)\\s*([^)]*)$", Pattern.CASE_INSENSITIVE);
        System.out.println(in.next(pt));

        in.close();
        List<Double> expr = new ArrayList<Double>();
        List<Character> action = new ArrayList<Character>();
        exprOne = 0;

      /*  try {
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

    @Override
    public Double sum(double a, double b) {
        return a+b;
    }

    @Override
    public Double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public Double sub(double a, double b) {
        return a-b;
    }

    @Override
    public Double div(double a, double b) {
        return a/b;
    }
}
