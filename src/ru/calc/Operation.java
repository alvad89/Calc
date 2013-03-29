package ru.calc;

/**
 *
 * User: a1
 * Date: 29.03.13
 * Time: 8:28
 * To change this template use File | Settings | File Templates.
 */
public interface Operation {
    public Double sum(double a, double b);
    public Double multiply(double a, double b);
    public Double sub(double a, double b);
    public Double div(double a, double b);
}
