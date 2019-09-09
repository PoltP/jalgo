package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        mergeSort(a, c, 0, a.length - 1);
    }
    private static <T> void mergeSort(T[] a, Comparator<T> c, int left, int right) {
        if(left >= right) return;
        int center = (right + left) / 2;
        mergeSort(a, c, left, center);
        mergeSort(a, c, center + 1, right);
        merge(a, c, left, center, right);
    }
    private static <T> void merge(T[] a, Comparator<T> c, int left, int center, int right) {
        int iCount = center - left + 1;
        int jCount = right - center;
        ArrayList<T> aLeft = new ArrayList<T>();
        ArrayList<T> aRight = new ArrayList<T>();
        for (int i = 0; i < iCount; i++) {
            aLeft.add(a[left + i]);
        }
        for (int j = 0; j < jCount; j++) {
            aRight.add(a[center + 1 + j]);
        }

        int i = 0;
        int j = 0;
        int k = left;
        while(i < iCount && j < jCount) {
            if(c.compare(aLeft.get(i), aRight.get(j)) < 0) {
                a[k] = aLeft.get(i++);
            } else {
                a[k] =  aRight.get(j++);
            }
            k++;
        }
        // There is possible only one (left or right) unfinished part
        while(i < iCount) {
            a[k++] = aLeft.get(i++);
        }
        while(j < jCount) {
            a[k++] = aRight.get(j++);
        }
    }
}
