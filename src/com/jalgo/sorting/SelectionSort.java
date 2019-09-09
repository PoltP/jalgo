package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;

import java.util.Comparator;

public class SelectionSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        for(int i = 0; i < a.length; i++) {
            select(a, c, i);
        }
    }

    private static <T> void select(T[] a, Comparator<T> c, int startIndex) {
        int index = startIndex;
        for(int j = startIndex; j < a.length - 1; j++) {
            if (c.compare(a[j +1], a[index]) < 0) {
                index = j + 1;
            }
        }
        Utils.swap(a, startIndex, index);
    }
}
