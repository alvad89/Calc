package ru.calc;

/**
 *
 * User: a1
 * Date: 29.03.13
 * Time: 8:28
 * To change this template use File | Settings | File Templates.
 */
public interface Operation {
    public String getSymbol();
    public Double evaluate(double a, double b);
}
