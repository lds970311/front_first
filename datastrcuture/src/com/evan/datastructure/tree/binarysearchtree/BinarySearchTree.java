package com.evan.datastructure.tree.binarysearchtree;

// Author : CSR丶SUSE
// Time ： 2021-12-19  22:48
// TOOLS : INTELLIJ IDEA
// FILENAME : BinarySearchTree.java
// STATEMENT: 二叉搜索树实现类


import com.evan.datastructure.queue.CircleQueue;
import com.evan.datastructure.test.printer.BinaryTreeInfo;
import com.evan.datastructure.tree.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements IBST<E>, BinaryTreeInfo, TraversalTree<E> {
    public int size;
    public TreeNode<E> root; //根节点
    public Comparator<E> comparator;

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
        return this.root == null;
    }

    @Override
    public void clearAll() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public TreeNode<E> find(E element) {
        if (element == null) return null;
        TreeNode<E> temp = root;
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

    /**
     * @return 二叉树高度
     */
    public int height() {
        if (root == null) return 0;
        int height = 0;
        int levelCount = 1; //记录每一层未访问节点的数量
        TreeNode<E> temp = this.root;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            TreeNode<E> node = queue.poll();
            levelCount--;

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (levelCount == 0) {
                //表示该层已经 访问完毕
                levelCount = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 递归计算二叉树高度
     *
     * @param node 传入的节点
     * @return height
     */
    public int height(TreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
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
                node.setElement(element);
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

    /**
     * 是否是完全二叉树
     *
     * @return true | false
     */
    public boolean isComplete() {
        if (root == null) return false;
        boolean leaf = false;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;
            if (node.getLeft() == null && node.getRight() != null) {
                return false;
            } else if (node.getLeft() != null && node.getRight() != null) {
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            } else {
                //判断是否只有左节点 或者是叶子节点
                leaf = true;
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
            }
        }
        return true;
    }


    /**
     * 翻转二叉树
     */
    public void reverseTree(TreeNode<E> node) {
        //中序遍历翻转
        if (node == null || node.isLeaf()) return;
        TreeNode<E> temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        reverseTree(node.getLeft());
        reverseTree(node.getRight());
    }

    public void reverseTree() {
        this.reverseTree(this.getRoot());
    }

    protected int compare(E e1, E e2) {
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
        if (element == null) return;
        this.size--;
        TreeNode<E> nodeToDelete = this.find(element);
        if (nodeToDelete.hasChildren()) {
            //是叶子节点
            TreeNode<E> predecessor = this.predecessor(element); //找到前驱节点
            nodeToDelete.setElement(predecessor.getElement()); //覆盖原来的值
            nodeToDelete = predecessor;
        }
        //要删除德节点度为0 或1
        TreeNode<E> replacement = nodeToDelete.getLeft() != null ? nodeToDelete.getLeft() : null;
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
        } else if (nodeToDelete.getParent() == null) {
            //度为0且为叶子节点
            root = null;
        } else {
            //普通叶子节点
            if (nodeToDelete == nodeToDelete.getParent().getLeft()) {
                //是父节点的左子节点
                nodeToDelete.getParent().setLeft(null);
            } else {
                nodeToDelete.getParent().setRight(null);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        if (element == null) return false;
        TreeNode<E> find = this.find(element);
        return find != null;
    }

    public void preorderTraversal() {
        this.preorderTraversal(this.getRoot());
    }

    public void inorderTraversal() {
        this.inorderTraversal(this.getRoot());
    }

    public void postorderTraversal() {
        this.postorderTraversal(this.getRoot());
    }

    public void levelOrderTraversal() {
        this.levelOrderTraversal(this.getRoot());
    }

    public void preorderTraversal(BSTVisitor<E> visitor, TreeNode<E> node) {
        if (node == null || visitor.stop) return;
        visitor.stop = visitor.visit(node.getElement());
        preorderTraversal(visitor, node.getLeft());
        preorderTraversal(visitor, node.getRight());
    }

    public void inorderTraversal(BSTVisitor<E> visitor, TreeNode<E> node) {
        if (node == null || visitor.stop) return;
        inorderTraversal(visitor, node.getLeft());
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.getElement());
        inorderTraversal(visitor, node.getRight());
    }

    public void postorderTraversal(BSTVisitor<E> visitor, TreeNode<E> node) {
        if (node == null || visitor.stop) return;
        postorderTraversal(visitor, node.getLeft());
        postorderTraversal(visitor, node.getRight());
//        System.out.println(node.getElement());
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.getElement());
    }

    public void levelOrderTraversal(BSTVisitor<E> visitor, TreeNode<E> node) {
        if (node == null) return;
        //使用队列
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode<E> parent = queue.poll();
            if (visitor.visit(parent.getElement())) {
                return;
            }
            if (parent.getLeft() != null) {
                queue.offer(parent.getLeft());
            }
            if (parent.getRight() != null) {
                queue.offer(parent.getRight());
            }
        }
    }


    /**
     * 前序遍历
     *
     * @param node 根节点
     */
    @Override
    public void preorderTraversal(TreeNode<E> node) {
        if (node == null) return;
        System.out.println(node.getElement());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }

    /**
     * 中序遍历
     *
     * @param node 根节点
     */
    @Override
    public void inorderTraversal(TreeNode<E> node) {
        if (node == null) return;
        inorderTraversal(node.getLeft());
        System.out.println(node.getElement());
        inorderTraversal(node.getRight());
    }

    /**
     * 后序遍历
     *
     * @param node 根节点
     */
    @Override
    public void postorderTraversal(TreeNode<E> node) {
        if (node == null) return;
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        System.out.println(node.getElement());
    }

    /**
     * 层序遍历
     *
     * @param node 根节点
     */
    @Override
    public void levelOrderTraversal(TreeNode<E> node) {
        if (node == null) return;
        //使用队列
        CircleQueue<TreeNode> queue = new CircleQueue<>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.dequeue();
            System.out.println(parent.getElement());
            if (parent.getLeft() != null) {
                queue.enqueue(parent.getLeft());
            }
            if (parent.getRight() != null) {
                queue.enqueue(parent.getRight());
            }
        }
    }

    /**
     * 获取前驱节点
     *
     * @param element 节点值
     * @return 前驱节点
     */
    public TreeNode<E> predecessor(E element) {
        TreeNode<E> node = this.find(element);
        if (node == null) return null;
        //左子树不为null , 获取其左子树的最大值
        TreeNode<E> temp = node.getLeft();
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

    public TreeNode<E> successor(E element) {
        TreeNode<E> node = this.find(element);
        if (node == null) return null;
        //右子树不为null , 获取其右子树的最小值
        TreeNode<E> temp = node.getRight();
        if (temp != null) {
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp;
        }
        while (node.getParent() != null && node == node.getParent().getRight()) {
            node = node.getParent();
        }
        return node.getParent();
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

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}
