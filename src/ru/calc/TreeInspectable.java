package ru.calc;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 11.04.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public interface TreeInspectable<E>{
    public Iterable<E> getPosition();
    //общие методы
    public int size();
    public boolean isEmpthy();
    public E element();
    //методы доступа
    public E root();
    public E parent(E e);
    public Iterable<E> children(E e);
    //методы запроса
    public boolean isNode(E e);
    public boolean isLeaf(E e);
    public boolean isRoot(E e);
    //методы заполнения
    //public boolean add(E e);
    //public boolean add(int index, E e);
    //public boolean remove(int index);
    public boolean addNode(E e, E parent);
    public boolean addLeaf(E e, E parent);
    public boolean removeNode(E e);
    public boolean removeLeaf(E e);
}


