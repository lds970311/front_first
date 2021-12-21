package com.evan.datastructure.test;

// Author : CSR丶SUSE
// Time ： 2021-12-19  23:41
// TOOLS : INTELLIJ IDEA
// FILENAME : BSTTest.java
// STATEMENT: 二叉排序树测试

import com.evan.datastructure.test.printer.BinaryTrees;
import com.evan.datastructure.tree.binarysearchtree.BSTVisitor;
import com.evan.datastructure.tree.binarysearchtree.BinarySearchTree;
import com.evan.datastructure.utils.WriteFiles;
import org.junit.Test;


public class BSTTest<E> {
    public static BinarySearchTree<Integer> initTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(8);
        int[] arr = {3, 1, 6, 4, 7, 10, 13, 14};
        for (int i : arr) {
            bst.add(i);
        }
        return bst;
    }

    @Test
    public void BST() {
        BinarySearchTree<Integer> bst = initTree();
        System.out.println(bst.size());
        BinaryTrees.println(bst);
        String str = BinaryTrees.printString(bst);
        WriteFiles.writeToFile("F:\\Java\\front_first\\datastrcuture\\result\\bst_data.txt", str + "\n", true);
    }

    @Test
    public void traverse() {
        BinarySearchTree<Integer> bst = initTree();
        /*bst.preorderTraversal(new BSTVisitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.println(element);
            }
        }, bst.getRoot());*/
        //bst.inorderTraversal();
        //bst.postorderTraversal();
        //bst.levelOrderTraversal();
        bst.levelOrderTraversal(new BSTVisitor<Integer>() {
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        }, bst.getRoot());
    }
}
