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

    public int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public boolean hasParent(int childIndex) {
        return parentIndex(childIndex) < size;
    }

    public boolean hasLeftChild(int parentIndex) {
        return leftChildIndex(parentIndex) < size;
    }

    public boolean hasRightChild(int parentIndex) {
        return rightChildIndex(parentIndex) < size;
    }

    public int parent(int childIndex) {
        return items[parentIndex(childIndex)];
    }

    public int leftChild(int parentIndex) {
        return items[leftChildIndex(parentIndex)];
    }

    public int rightChild(int parentIndex) {
        return items[rightChildIndex(parentIndex)];
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException("size == 0");
        return items[0];
    }

    public int poll() {
        int item = peek();
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {// no right child also
            int smallerChildIndex = hasRightChild(index) && compare(rightChild(index), leftChild(index)) ?
                rightChildIndex(index) : leftChildIndex(index);
            if (compare(items[index], items[smallerChildIndex])) {
                break;
            } else {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && compare(parent(index), items[index])) {
            int newIndex = parentIndex(index);
            swap(newIndex, index);
            index = newIndex;
        }
    }

    private void swap(int index1, int index2) {
        Integer tmp = items[index2];
        items[index2] = items[index1];
        items[index1] = tmp;
    }

    private boolean compare(int left, int right) {
        return comparator.compare(left, right) > 0;
    }
}
