package com.evan.datastructure.tree.avltree;

// Author : CSR丶SUSE
// Time ： 2021-12-23  16:54
// TOOLS : INTELLIJ IDEA
// FILENAME : AVLTree.java
// STATEMENT: AVL树(平衡二叉搜索树的一种)


import com.evan.datastructure.test.printer.BinaryTreeInfo;
import com.evan.datastructure.tree.AVLNode;
import com.evan.datastructure.tree.binarysearchtree.BinarySearchTree;

import java.util.Comparator;

public class AVLTree<T> extends BinarySearchTree<T> implements BinaryTreeInfo {
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
        afterAdd(newNode); //bst -> avl
        this.size++;
    }

    private void afterAdd(AVLNode<T> node) {
        while ((node = node.getParent()) != null) {
            if (node.isBalance(node)) {
                //更新高度
                node.updateHeight(node);
            } else {
                //不平衡, 恢复平衡
                this.reBalance(node);
                break;
            }
        }
    }


    /**
     * 恢复平衡(核心)
     *
     * @param grand node
     */
    private void reBalance(AVLNode<T> grand) {
        AVLNode<T> parent = grand.tallerChild();
        AVLNode<T> node = parent.tallerChild();
        if (parent.isLeftChild()) {
            //L
            if (node.isLeftChild()) {
                //LL
                this.rightRotate(grand);
            } else {
                //LR
                this.leftRotate(parent);
                this.rightRotate(grand);
                //不平衡的节点在parent 的l R ,先左旋转再有旋转
            }
        } else {
            //R
            if (node.isLeftChild()) {
                //RL
                this.rightRotate(parent);
                this.leftRotate(grand);
            } else {
                //RR
                this.leftRotate(grand);
            }
        }
    }

    /**
     * 右旋转
     *
     * @param grand 不平衡的那个节点
     */
    private void rightRotate(AVLNode<T> grand) {
        AVLNode<T> parent = grand.getLeft();
        AVLNode<T> child = parent.getRight();
        grand.setLeft(child);
        parent.setRight(grand);
        this.afterRotate(grand, parent, child);
    }


    /**
     * 左旋转
     *
     * @param grand 不平衡的那个节点
     */
    private void leftRotate(AVLNode<T> grand) {
        AVLNode<T> parent = grand.getRight();
        AVLNode<T> child = parent.getLeft();
        grand.setRight(child);
        parent.setLeft(grand);
        //更新父节点
        this.afterRotate(grand, parent, child);
    }

    /**
     * 左旋转 右旋转中相同的逻辑
     *
     * @param grand
     * @param parent
     * @param child
     */
    private void afterRotate(AVLNode<T> grand, AVLNode<T> parent, AVLNode<T> child) {
        //更新父节点
        parent.setParent(grand.getParent());
        //grand成为原先grand的位置, 其父节点需要更新
        if (grand.isLeftChild()) {
            grand.getParent().setLeft(parent);
        } else if (grand.isRightChild()) {
            grand.getParent().setRight(parent);
        } else {
            //说明没有parent
            this.root = parent;
        }
        //更新左子树的parent
        if (child != null) {
            child.setParent(grand); //应该没必要更新吧...
        }
        grand.setParent(parent);
        grand.updateHeight();
        parent.updateHeight();

    }

    public AVLNode<T> findElement(T element) {
        if (element == null) return null;
        AVLNode<T> temp = root;
        while (temp != null) {
            int cmp = this.compare(element, temp.getElement());
            if (cmp == 0) {
                return temp;
            } else if (cmp > 0) {
                temp = temp.getRight();
            } else {
                temp = temp.getLeft();
            }
        }
        return null;
    }

    private AVLNode<T> getPredecessor(T element) {
        if (element == null) return null;
        AVLNode<T> node = this.findElement(element);
        if (node == null) return null;
        //左子树不为null , 获取其左子树的最大值
        AVLNode<T> temp = node.getLeft();
        if (temp != null) {
            while (temp.getRight() != null) {
                temp = temp.getRight();
            }
            return temp;
        }
        //左子树为null, 寻找parent,知道node在parent的右子树为止
        while (node.getParent() != null && node == node.getParent().getLeft()) {
            node = node.getParent();
        }
        return node.getParent();
    }

    public void remove(T element) {
        if (element == null) return;
        this.size--;
        AVLNode<T> nodeToDelete = this.findElement(element);
        if (nodeToDelete == null) return;
        if (nodeToDelete.hasChildren()) {
            //是叶子节点
            AVLNode<T> predecessor = this.getPredecessor(element); //找到前驱节点
            nodeToDelete.setElement(predecessor.getElement()); //覆盖原来的值
            nodeToDelete = predecessor;
        }
        //要删除德节点度为0 或1
        AVLNode<T> replacement = nodeToDelete.getLeft() != null ? nodeToDelete.getLeft() : null;
        //度为1
        if (replacement != null) {
            //度为1
            replacement.setParent(nodeToDelete.getParent());
            if (nodeToDelete.getParent() == null) {
                //度为1的根节点
                this.root = replacement;
            } else if (nodeToDelete == nodeToDelete.getParent().getLeft()) {
                nodeToDelete.getParent().setLeft(replacement);
            } else {
                nodeToDelete.getParent().setRight(replacement);
            }
            afterRemove(nodeToDelete);
        } else if (nodeToDelete.getParent() == null) {
            //度为0且为叶子节点
            root = null;
            afterRemove(nodeToDelete);
        } else {
            //普通叶子节点
            if (nodeToDelete == nodeToDelete.getParent().getLeft()) {
                //是父节点的左子节点
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }
            afterRemove(nodeToDelete);
        }
    }

    private void afterRemove(AVLNode<T> node) {
        while ((node = node.getParent()) != null) {
            if (node.isBalance()) {
                node.updateHeight();
            } else {
                this.reBalance(node);
            }
        }
    }

    @Override
    public Object root() {
        return this.root;
    }

    @Override
    public Object left(Object node) {
        return ((AVLNode<T>) node).getLeft();
    }

    @Override
    public Object right(Object node) {
        return ((AVLNode<T>) node).getRight();
    }

    @Override
    public Object string(Object node) {
        AVLNode<T> myNode = (AVLNode<T>) node;
        String parentString = "null";
        if (myNode.getParent() != null) {
            parentString = myNode.getParent().getElement().toString();
        }
        return myNode.getElement();
    }
}
