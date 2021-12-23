package com.evan.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 链接: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 描述: 根据一棵树的中序遍历与后序遍历构造二叉树;
 * 例如: 中序遍历 inorder = [9,3,15,20,7]; 后序遍历 postorder = [9,15,7,20,3]
 * ---- 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 思路: 找到根节点, 并找到中序遍历中对应根节点的index, 计算左子树,右子树的起始位置, 递归进行构建即可!
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, map, 0, inLen - 1, 0, postLen - 1);
    }

    private TreeNode build(int[] postorder, Map<Integer, Integer> map, int inLeft, int inRight,
                           int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        int pIndex = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = build(postorder, map, inLeft, pIndex - 1, postLeft, pIndex - 1 - inLeft + postLeft);
        node.right = build(postorder, map, pIndex + 1, inRight, postRight - inRight + pIndex, postRight - 1);
        return node;
    }
}
