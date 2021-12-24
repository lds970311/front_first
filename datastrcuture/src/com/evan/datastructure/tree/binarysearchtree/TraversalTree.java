package com.evan.datastructure.tree.binarysearchtree;
// Author : CSR丶SUSE
// Time ： 2021-12-20  19:16
// TOOLS : INTELLIJ IDEA
// FILENAME : TraversalTree.java
// STATEMENT: 

import com.evan.datastructure.tree.TreeNode;

public interface TraversalTree<E> {

    void preorderTraversal(TreeNode<E> node);

    void inorderTraversal(TreeNode<E> node);

    void postorderTraversal(TreeNode<E> node);

    void levelOrderTraversal(TreeNode<E> node);
}
