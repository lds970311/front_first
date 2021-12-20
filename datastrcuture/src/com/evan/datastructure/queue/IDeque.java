package com.evan.datastructure.queue;

public interface IDeque<E> extends IQueue<E> {
    void enQueueFront(E element);

    E deQueueRear();
}
