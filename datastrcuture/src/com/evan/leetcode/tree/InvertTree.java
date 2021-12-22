package com.evan.leetcode.tree;

// Author : CSR丶SUSE
// Time ： 2021-12-21  23:43
// TOOLS : INTELLIJ IDEA
// FILENAME : InvertTree.java
// STATEMENT: 


public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
