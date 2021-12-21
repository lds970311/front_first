package com.evan.datastructure.tree.binarysearchtree;
// Author : CSR丶SUSE
// Time ： 2021-12-20  23:35
// TOOLS : INTELLIJ IDEA
// FILENAME : BSTVisitor.java
// STATEMENT: 

/**
 * 遍历bst时的访问器
 */
public abstract class BSTVisitor<T> {
    boolean stop = false;

    public abstract boolean visit(T element);
}
