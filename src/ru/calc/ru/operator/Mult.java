package ru.calc.ru.operator;

import ru.calc.Operation;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 16.04.13
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
public class Mult implements Operation {
    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public Double evaluate(double a, double b) {
        return a*b;
    }
}
