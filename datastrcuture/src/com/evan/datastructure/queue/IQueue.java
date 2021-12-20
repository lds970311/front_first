package com.evan.datastructure.queue;

public interface IQueue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();

    E front();

    void clear();
}
