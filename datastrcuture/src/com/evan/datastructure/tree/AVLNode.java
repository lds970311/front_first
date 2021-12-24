package com.evan.datastructure.tree;

// Author : CSR丶SUSE
// Time ： 2021-12-23  20:52
// TOOLS : INTELLIJ IDEA
// FILENAME : AVLNode.java
// STATEMENT: 


public class AVLNode<E> implements INode<E> {
    private E element;
    private AVLNode<E> left;
    private AVLNode<E> right;
    private AVLNode<E> parent;
    private int height;

    public AVLNode(E element, AVLNode<E> parent) {
        this.element = element;
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    /**
     * 是否是叶子节点
     *
     * @return true
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public E getElement() {
        return element;
    }

    /**
     * 节点两侧是否平衡
     *
     * @return true | false
     */
    public boolean isBalance(AVLNode<E> node) {
        return Math.abs(node.balanceFactor()) <= 1;
    }


    public void setElement(E element) {
        this.element = element;
    }

    public AVLNode<E> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<E> left) {
        this.left = left;
    }

    public AVLNode<E> getRight() {
        return right;
    }

    public void setRight(AVLNode<E> right) {
        this.right = right;
    }

    public AVLNode<E> getParent() {
        return parent;
    }

    public void setParent(AVLNode<E> parent) {
        this.parent = parent;
    }

    public boolean hasChildren() {
        return this.left != null && this.right != null;
    }

    public int getHeight() {
        return height;
    }

    public int balanceFactor() {
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        return leftHeight - rightHeight;
    }

    public void updateHeight(AVLNode<E> node) {
        node.updateHeight();
    }

    public void updateHeight() {
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        this.height = 1 + Math.max(rightHeight, leftHeight);
    }

    public boolean isLeftChild() {
        return parent != null && this == parent.left;
    }

    public boolean isRightChild() {
        return parent != null && this == parent.right;
    }

    public AVLNode<E> tallerChild() {
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        if (leftHeight > rightHeight) return left;
        if (leftHeight < rightHeight) return right;
        return isLeftChild() ? left : right;
    }

    @Override
    public String toString() {
        return "AVLNode:" + element;
    }
}
