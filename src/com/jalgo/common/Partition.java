package com.jalgo.common;

import java.util.Comparator;

public final class Partition {
    public static <T> int lomuto(T[] a, Comparator<T> c, int low, int high) {
        T pivot = a[high];
        int i = low;
        for(int j = low; j < high; j++) {
            if(c.compare(a[j], pivot) <= 0) {
                Utils.swap(a, i, j);
                i++;
            }
        }
        Utils.swap(a, i, high);
        return i;
    }
    public static <T> int hoare(T[] a, Comparator<T> c, int low, int high) {
        T pivot = a[low + (high - low) / 2];
        int i = low - 1, j = high + 1;
        while(true) {
            do {
                i++;
            } while(c.compare(a[i], pivot) < 0);
            do {
                j--;
            } while(c.compare(a[j], pivot) > 0);
            if(i >= j) {
                return j;
            }
            Utils.swap(a, i, j);
        }
    }
//    private int getRandomPivot(int left, int right) {
//        return left + (int)((right - left) * Math.random());
//    }
}
