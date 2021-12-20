package com.evan.datastructure.tree.binarysearchtree;

// Author : CSR丶SUSE
// Time ： 2021-12-19  22:48
// TOOLS : INTELLIJ IDEA
// FILENAME : BinarySearchTree.java
// STATEMENT: 二叉搜索树实现类


import com.evan.datastructure.test.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinarySearchTree<E> implements IBST<E>, BinaryTreeInfo {
    private int size;
    private TreeNode<E> root; //根节点
    private final Comparator<E> comparator;

    public BinarySearchTree() {
        this.size = 0;
        this.comparator = null;
    }

    public BinarySearchTree(E element) {
        this.size = 1;
        this.root = new TreeNode<>(element, null);
        this.comparator = null;
    }

    public BinarySearchTree(E element, Comparator<E> comparator) {
        this.size = 1;
        this.root = new TreeNode<>(element, null);
        this.comparator = comparator;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clearAll() {

    }

    /**
     * 添加元素
     *
     * @param element 元素
     */
    @Override
    public void add(E element) {
        this.elementNullCheck(element);
        if (root == null) {
            this.root = new TreeNode<>(element, null);
            return;
        }
        //创建临时父节点和根节点
        TreeNode<E> node = root;
        TreeNode<E> parent = null;
        int cmp = 0; //比较结果
        while (node != null) {
            cmp = this.compare(node.getElement(), element);
            parent = node;
            if (cmp < 0) {
                node = node.getRight();
            } else if (cmp > 0) {
                node = node.getLeft();
            } else {
                return;
            }
        }
        TreeNode<E> newNode = new TreeNode<>(element, parent);
        if (cmp < 0) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }
        this.size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void elementNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element can not be null!");
        }
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public Object root() {
        return this.root;
    }

    @Override
    public Object left(Object node) {
        return ((TreeNode<E>) node).getLeft();
    }

    @Override
    public Object right(Object node) {
        return ((TreeNode<E>) node).getRight();
    }

    @Override
    public Object string(Object node) {
        TreeNode<E> myNode = (TreeNode<E>) node;
        String parentString = "null";
        if (myNode.getParent() != null) {
            parentString = myNode.getParent().getElement().toString();
        }
        return myNode.getElement();
    }
}
