package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;
import java.util.Comparator;

// Just for experiment
public class HeapSortEx<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        for(int i = 0; i < a.length; i++) {
            build(a, c, a.length - 1 - i);
        }
    }
    private static <T> void build(T[] a, Comparator<T> c, int endIndex) {
        int size = (int)Math.floor((endIndex + 1) / 2);
        for(int j = size - 1; j >= 0; j--) {
            int left = 2 * j + 1;
            int right = 2 * j + 2;
            int index = -1;
            if(left <= endIndex && right <= endIndex)
                index = c.compare(a[left], a[right]) > 0 ? left : right;
            else if(left > endIndex && right <= endIndex)
                index = right;
            else if(left <= endIndex && right > endIndex)
                index = left;
            else
                continue;
            if(c.compare(a[index], a[j]) > 0)
                Utils.swap(a, j, index);
        }
        Utils.swap(a, 0, endIndex);
    }
}
