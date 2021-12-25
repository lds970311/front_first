package com.evan.datastructure.test;

// Author : CSR丶SUSE
// Time ： 2021-12-24  23:15
// TOOLS : INTELLIJ IDEA
// FILENAME : AVLTest.java
// STATEMENT: 


import com.evan.datastructure.test.printer.BinaryTrees;
import com.evan.datastructure.tree.avltree.AVLTree;
import org.junit.Test;

public class AVLTest {
    public static AVLTree<Integer> initAVLTree() {
        AVLTree<Integer> avlTree = new AVLTree<>(10);
        int[] arr = {9, 8, 7, 6, 5, 4};
        for (int i : arr) {
            avlTree.add(i);
        }
        return avlTree;
    }

    @Test
    public void add() {
        AVLTree<Integer> avlTree = initAVLTree();
        System.out.println(avlTree.size());
        BinaryTrees.println(avlTree);
    }
}
