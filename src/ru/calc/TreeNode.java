package ru.calc;

/**
 * Created with IntelliJ IDEA.
 * User: a1
 * Date: 12.04.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {
    private transient TreeNode left, right, parent;
    private transient Object element;

    public TreeNode(){

    }
    public TreeNode(Object o, TreeNode leftChild, TreeNode rightChild, TreeNode parentNode){
        setElement(o);
        setLeft(leftChild);
        setRight(rightChild);
        setParent(parentNode);
    }


    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
