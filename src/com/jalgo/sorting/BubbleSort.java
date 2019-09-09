package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;
import java.util.Comparator;

public class BubbleSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        for(int i = 0; i < a.length - 1; i++) {
            if(!bubble(a, c, a.length - 1 - i))
                break;
        }
    }

    private static <T> boolean bubble(T[] a, Comparator<T> c, int endIndex) {
        boolean swapped = false;
        for(int j = 0; j < endIndex; j++) {
            if (c.compare(a[j], a[j + 1]) > 0) {
                Utils.swap(a, j, j + 1);
                swapped = true;
            }
        }
        return swapped;
    }
}
