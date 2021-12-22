package com.evan.leetcode.tree;

import java.util.*;

/**
 * 链接: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 题目: 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) return all;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            all.add(list);
        }
        Collections.reverse(all);
        return all;
    }
}
