package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;
import java.util.Comparator;

public class InsertSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        for(int i = 0; i < a.length; i++) {
            insert(a, c, i);
        }
    }

    private static <T> void insert(T[] a, Comparator<T> c, int index) {
        for(int j = index; j > 0; j--) {
            if (c.compare(a[j], a[j - 1]) < 0) {
                Utils.swap(a, j, j - 1);
            } else {
                break;
            }
        }
    }
}
