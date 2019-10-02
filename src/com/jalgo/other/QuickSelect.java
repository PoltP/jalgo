package com.jalgo.other;

import com.jalgo.common.Partition;

import java.util.Comparator;

public final class QuickSelect {
    public static <T> T findKthSmallestHoare(T[] a, Comparator<T> c, int low, int high, int k) {
        return findKthSmallest(a, c, low, high, k, true);
    }

    public static <T> T findKthSmallestLomuto(T[] a, Comparator<T> c, int low, int high, int k) {
        return findKthSmallest(a, c, low, high, k, false);
    }

    private static <T> T findKthSmallest(T[] a, Comparator<T> c, int low, int high, int k, boolean isHoare) {
        int index = low + k;
        while (low < high) {
            int pivot = isHoare ? Partition.hoare(a, c, low, high) : Partition.lomuto(a, c, low, high);
            if (pivot < index) {
                low = pivot + 1;
            } else if (pivot > index) {
                high = pivot - 1;
            } else {
                return a[pivot];
            }
        }
        return a[low];
    }
}
