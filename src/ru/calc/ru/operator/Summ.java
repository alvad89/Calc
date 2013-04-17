package ru.calc.ru.operator;

import ru.calc.Operation;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 16.04.13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class Summ implements Operation {

    public String getSymbol() {
        return "+";
    }

    public Double evaluate(double a, double b) {
        return a+b;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
