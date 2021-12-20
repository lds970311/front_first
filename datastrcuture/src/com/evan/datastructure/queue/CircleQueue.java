// AUTHOR: CSR丶SUSE
// TIME : 2021/9/1  12:59
// FILENAME: CircleQueue.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.datastructure.queue;

//循环队列
@SuppressWarnings("unchecked")
public class CircleQueue<E> implements IQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int front;
    private int size;
    private E[] elements;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    @Override
    public E dequeue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }


    @Override
    public E front() {
        return elements[front];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    private int index(int index) {
        index += front;
        return index % this.elements.length;
    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        front = 0;
    }
}

