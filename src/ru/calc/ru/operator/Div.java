package ru.calc.ru.operator;

import ru.calc.Operation;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 16.04.13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class Div implements Operation {
    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public Double evaluate(double a, double b) {
        return a/b;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
