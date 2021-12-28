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
        AVLTree<Integer> avlTree = new AVLTree<>(96);
        int[] arr = {99, 62, 4, 89, 86, 59, 72, 58, 12, 85, 3, 91, 40, 80};
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

    @Test
    public void remove() {
        AVLTree<Integer> avlTree = initAVLTree();
        avlTree.remove(86);
        System.out.println(avlTree.size());
        BinaryTrees.println(avlTree);
    }

    public void myTest() {
    }

}
