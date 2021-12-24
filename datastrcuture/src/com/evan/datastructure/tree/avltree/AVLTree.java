package com.evan.datastructure.tree.avltree;

// Author : CSR丶SUSE
// Time ： 2021-12-23  16:54
// TOOLS : INTELLIJ IDEA
// FILENAME : AVLTree.java
// STATEMENT: AVL树(平衡二叉搜索树的一种)


import com.evan.datastructure.tree.AVLNode;
import com.evan.datastructure.tree.binarysearchtree.BinarySearchTree;

import java.util.Comparator;

public class AVLTree<T> extends BinarySearchTree<T> {
    private AVLNode<T> root; //根节点

    public AVLTree() {
        super();
    }

    public AVLTree(T element) {
        this.size = 1;
        this.root = new AVLNode<T>(element, null);
        this.comparator = null;
    }

    public AVLTree(T element, Comparator<T> comparator) {
        super(element, comparator);
    }

    public void add(T element) {
        this.elementNullCheck(element);
        if (this.root == null) {
            this.root = new AVLNode<>(element, null);
            return;
        }
        //创建临时父节点和根节点
        AVLNode<T> node = root;
        AVLNode<T> parent = null;
        int compare = 0; //比较结果
        while (node != null) {
            compare = this.compare(node.getElement(), element);
            parent = node;
            if (compare < 0) {
                node = node.getRight();
            } else if (compare > 0) {
                node = node.getLeft();
            } else {
                node.setElement(element);
                return;
            }
        }
        AVLNode<T> newNode = new AVLNode<>(element, parent);
        if (compare < 0) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }
        afterAdd(newNode);
        this.size++;
    }

    private void afterAdd(AVLNode<T> node) {
        while ((node = node.getParent()) != null) {
            if (node.isBalance(node)) {
                //更新高度
                node.updateHeight(node);
            } else {
                //不平衡, 恢复平衡
                this.rebalance(node);
                break;
            }
        }
    }

    /**
     * 恢复平衡(核心)
     *
     * @param grand node
     */
    private void rebalance(AVLNode<T> grand) {
        AVLNode<T> parent = grand.tallerChild();
        AVLNode<T> node = parent.tallerChild();
    }
}
