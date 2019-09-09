package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.QuickSelect;

import java.util.Comparator;

public class QuickHoareSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        quickSort(a, c, 0, a.length - 1);
    }

    private static <T> void quickSort(T[] a, Comparator<T> c, int low, int high) {
       if(low >= high) return;
       int pivot = QuickSelect.partitionHoare(a, c, low, high);
       quickSort(a, c, low, pivot);
       quickSort(a, c, pivot + 1, high);
    }
}
