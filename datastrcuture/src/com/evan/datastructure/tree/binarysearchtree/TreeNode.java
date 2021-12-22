package com.evan.datastructure.tree.binarysearchtree;

// Author : CSR丶SUSE
// Time ： 2021-12-19  23:04
// TOOLS : INTELLIJ IDEA
// FILENAME : TreeNode.java
// STATEMENT: 


public class TreeNode<E> {
    private E element;
    private TreeNode<E> left;
    private TreeNode<E> right;
    private TreeNode<E> parent;

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
        this.left = null;
        this.right = null;
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


    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }
}
