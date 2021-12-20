


package com.evan.datastructure.queue;

import org.junit.jupiter.api.Test;

/**
 * 循环双端队列
 */
@SuppressWarnings("unchecked")
public class CircleDeque<E> implements IDeque<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int front;
    private int size;
    private E[] elements;

    public CircleDeque() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);

        this.front = index(-1);
        this.elements[front] = element;
        this.size++;
    }

    @Override
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    @Override
    public E dequeue() {
        E frontElement = this.elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    @Override
    public E front() {
        return this.elements[front];
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
        if (index < 0) {
            return index + elements.length;
        }
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

    @Test
    public void circleDequeTest() {
        CircleDeque<Integer> circleDeque = new CircleDeque<>();
        for (int i = 3; i < 7; i++) {
            circleDeque.enqueue(i);
        }

        for (int i = 11; i < 15; i++) {
            circleDeque.enQueueFront(i);
        }

        while (!circleDeque.isEmpty()) {
            // System.out.println(circleDeque.dequeue());
            System.out.println(circleDeque.deQueueRear());
        }
    }
}
