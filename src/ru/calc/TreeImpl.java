package ru.calc;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 11.04.13
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public class TreeImpl extends AbstractList<TreeNode> implements TreeInspectable<TreeNode>{

    private transient Object[] elementData;
    private int size;
    private TreeNode root;

    //public TreeImpl(E[] elementData) {
    //    this.elementData = elementData;
    //}
   // public TreeImpl(int initialSize){
   //     super();
   //     if(initialSize<0) throw new IllegalArgumentException("Error capasity: " + initialSize);
   //     //this.size = initialSize;

   //     this.elementData =  new Object[initialSize];
   // }
    public TreeImpl(int capasity){
        super();
        if (capasity<0) throw new IllegalArgumentException("Error capasity");
        this.elementData = new Object[capasity];
        //size = 1;
        //root = new TreeNode(null,null,null,null);
        //elementData[0] = root;
    }
    public TreeImpl(){
        this(10);
    }

    @Override
    public Iterable<TreeNode> getPosition() {
        return null;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpthy() {
        return (size==0);
    }

    @Override
    public TreeNode element() {
        return null;
    }

    @Override
    public TreeNode root() {
        return root;
    }

    @Override
    public boolean isNode(TreeNode e) {
        return (e.getLeft()!=null && ((TreeNode) e).getRight()!=null);
    }

    @Override
    public boolean isLeaf(TreeNode e) {
        return (( e.getLeft() == null) && (((TreeNode) e).getRight() == null));
    }

    @Override
    public boolean isRoot(TreeNode e) {
        return (e==root());
    }

    @Override
    public TreeNode getLeftChild(TreeNode e) {
        return ((TreeNode) e).getLeft();
    }

    @Override
    public TreeNode getRightChild(TreeNode e) {
        return ((TreeNode) e).getRight();
    }

    @Override
    public TreeNode getParent(TreeNode e) {
        return ((TreeNode) e).getParent();
    }

    @Override
    public TreeNode getSibling(TreeNode e) {
        TreeNode parent =  getParent(e);
        TreeNode left = getLeftChild(parent);
        if (parent==left) return getRightChild(parent);
        else return left;
    }


    @Override
    public void addNode(TreeNode e) {
        ensureCapacity(size+1);
        if(isNode(e)){
            e.setRight(e.getParent());//new TreeNode(null,null,null, e));
            e.setLeft(e.getParent());//new TreeNode(null,null,null, e));
            size +=2;
            elementData[size+1] = e;
        }
    }

    @Override
    public void removeNode(TreeNode e) {
         if (isNode(e)){
             TreeNode parent =getParent(e);
             TreeNode sibl = getSibling(e);
             if(isRoot(parent)){
                 sibl.setParent(parent);
                 root = parent;
             }
             else {
                 TreeNode tr = (TreeNode) getParent(parent);
                 if (parent==getLeftChild(tr)){
                    tr.setLeft(sibl);
                 }
                 else tr.setRight(sibl);
                 sibl.setParent(tr);
             }
         }
    }

    @Override
    public TreeNode get(int i) {
        return (TreeNode)elementData[i];
    }
    public void ensureCapacity(int minCapacity) {
        modCount++;
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            Object oldData[] = elementData;
            int newCapacity = (oldCapacity * 3)/2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

}
