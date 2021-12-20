package com.evan.datastructure.test;

// Author : CSR丶SUSE
// Time ： 2021-12-19  23:41
// TOOLS : INTELLIJ IDEA
// FILENAME : BSTTest.java
// STATEMENT: 

import com.evan.datastructure.test.printer.BinaryTrees;
import com.evan.datastructure.tree.binarysearchtree.BinarySearchTree;
import org.junit.Test;


public class BSTTest {
    @Test
    public void BST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(8);
        int[] arr = {3, 1, 6, 4, 7, 10, 13, 14};
        for (int i : arr) {
            bst.add(i);
        }
        System.out.println(bst.size());
        BinaryTrees.println(bst);
    }
}
