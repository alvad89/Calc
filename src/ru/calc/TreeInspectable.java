package ru.calc;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 11.04.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public interface TreeInspectable<TreeNode>{
    public Iterable<TreeNode> getPosition();
    //общие методы
    public int size();
    public boolean isEmpthy();
    public TreeNode element();
    //методы доступа
    public TreeNode getRoot();
    //public E parent(E e);
    //public Iterable<E> children(E e);
    //методы запроса
    public boolean isNode(TreeNode e);
    public boolean isLeaf(TreeNode e);
    public boolean isRoot(TreeNode e);
    //методы заполнения
    public TreeNode getLeftChild(TreeNode e);
    public TreeNode getRightChild(TreeNode e);
    public TreeNode getParent(TreeNode e);
    public TreeNode getSibling(TreeNode e);
    public void addNode(TreeNode e);
    public void removeNode(TreeNode e);
    //public boolean add(E e);
    //public boolean add(int index, E e);
    //public boolean remove(int index);
    //public boolean addNode(E e, E parent);
    //public boolean addLeaf(E e, E parent);
    //public boolean removeNode(E e);
    //public boolean removeLeaf(E e);
}


