package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;

import java.util.Comparator;

public class HeapSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        for(int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, c, i, a.length);
        }
        for(int i = a.length - 1; i > 0; i--) {
            Utils.swap(a, 0, i);
            heapify(a, c, 0, i);
        }
    }
    private static <T> void heapify(T[] a, Comparator<T> c, int index, int size) {
        int position = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if(left < size && c.compare(a[position], a[left]) < 0) {
            position = left;
        }
        if(right < size && c.compare(a[position], a[right]) < 0) {
            position = right;
        }

        if(position != index) {
            Utils.swap(a, position, index);
            heapify(a, c, position, size);
        }
    }
}
