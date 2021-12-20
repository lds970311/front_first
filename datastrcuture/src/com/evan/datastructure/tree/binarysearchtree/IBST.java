package com.evan.datastructure.tree.binarysearchtree;
// Author : CSR丶SUSE
// Time ： 2021-12-19  22:48
// TOOLS : INTELLIJ IDEA
// FILENAME : IBST.java
// STATEMENT: 二叉搜索树接口

public interface IBST<E> {
    int size();

    boolean isEmpty();

    void clearAll();

    void add(E element);

    void remove(E element);

    boolean contains(E element);
}
