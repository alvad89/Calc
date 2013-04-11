package ru.calc;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 11.04.13
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public class TreeImpl<E> extends AbstractList<E> implements TreeInspectable<E>{

    private Object[] elementData;
    private int size;

    public TreeImpl(Object[] elementData) {
        this.elementData = elementData;
    }
    public TreeImpl(int size){
        this.size = size;
    }
    public TreeImpl(){

    }

    @Override
    public E get(int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterable<E> getPosition() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpthy() {
        return false;  //дерево не может быть пустым
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E root() {
        return null;
    }

    @Override
    public E parent(E e) {
        return null;
    }

    @Override
    public Iterable<E> children(E e) {
        return null;
    }

    @Override
    public boolean isNode(E e) {
        return false;
    }

    @Override
    public boolean isLeaf(E e) {
        return false;
    }

    @Override
    public boolean isRoot(E e) {
        return false;
    }

    @Override
    public boolean addNode(E e, E parent) {
        return false;
    }

    @Override
    public boolean addLeaf(E e, E parent) {
        return false;
    }

    @Override
    public boolean removeNode(E e) {
        return false;
    }

    @Override
    public boolean removeLeaf(E e) {
        return false;
    }
}
