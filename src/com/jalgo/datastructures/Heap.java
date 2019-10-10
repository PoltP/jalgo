package com.jalgo.datastructures;

import java.util.Arrays;
import java.util.Comparator;

public class Heap {
    int size = 0;
    int capacity;
    Integer[] items;
    Comparator<Integer> comparator;

    public Heap(Integer[] a, Comparator<Integer> comparator) {
        this(a.length + 1, comparator);
        for (int i = 0; i < a.length; ++i) {
            this.add(a[i]);
        }
    }

    private Heap(int capacity, Comparator<Integer> comparator) {
        if (capacity <= 1)
            throw new IllegalArgumentException("Capacity > 1");
        this.capacity = capacity;
        this.items = new Integer[capacity];
        this.comparator = comparator;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public boolean hasParent(int childIndex) {
        return this.getParentIndex(childIndex) < size;
    }

    public boolean hasLeftChild(int parentIndex) {
        return this.getLeftChildIndex(parentIndex) < size;
    }

    public boolean hasRightChild(int parentIndex) {
        return this.getRightChildIndex(parentIndex) < size;
    }

    public int getParent(int childIndex) {
        return this.items[getParentIndex(childIndex)];
    }

    public int getLeftChild(int parentIndex) {
        return this.items[this.getLeftChildIndex(parentIndex)];
    }

    public int getRightChild(int parentIndex) {
        return this.items[this.getRightChildIndex(parentIndex)];
    }

    public int peek() {
        if (this.size == 0)
            throw new IllegalStateException("size == 0");
        return this.items[0];
    }

    public int poll() {
        int item = this.peek();
        this.items[0] = this.items[this.size - 1];
        this.size--;
        this.heapifyDown();
        return item;
    }

    public void add(int item) {
        this.ensureCapacity();
        this.items[this.size] = item;
        this.size++;
        this.heapifyUp();
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            capacity *= 2;
            this.items = Arrays.copyOf(this.items, capacity);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (this.hasLeftChild(index)) {// no right child also
            int smallerChildIndex = this.getLeftChildIndex(index);
            if (this.hasLeftChild(index) && this.comparator.compare(this.getRightChild(index), this.getLeftChild(index)) > 0) {
                smallerChildIndex = this.getRightChildIndex(index);
            }
            if (this.comparator.compare(this.items[index], this.items[smallerChildIndex]) > 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    private void heapifyUp() {
        int index = this.size - 1;
        while (this.hasParent(index) && this.comparator.compare(this.getParent(index), this.items[index]) > 0) {
            swap(this.getParentIndex(index), index);
            index = this.getParentIndex(index);
        }
    }

    private void swap(int index1, int index2) {
        Integer tmp = this.items[index2];
        this.items[index2] = this.items[index1];
        this.items[index1] = tmp;
    }
}
