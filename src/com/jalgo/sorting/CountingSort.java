package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import com.jalgo.common.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class CountingSort<T> implements ISortable<T> {
    public void sort(T[] a, Comparator<T> c) {
        T minElement = Arrays.stream(a).min(c).get();
        T maxElement = Arrays.stream(a).max(c).get();
        if(!(minElement instanceof Integer && maxElement instanceof Integer))
            throw new IllegalArgumentException("Counting sort works only with Integer data types or types which can be interpreted as Integer");

        Integer min = (Integer)minElement;
        Integer max = (Integer)maxElement;
        boolean isAscending = max >= min;
        if(!isAscending) {
            Integer tmp = min;
            min = max;
            max = tmp;
        }
        Integer count = max - min + 1;
        int[] counts = new int[count];
        Integer[] aSorted = new Integer[a.length];

        for(int i = 0; i < a.length; i++) {
            counts[nextIndex(a, min, i)]++;
        }

        // Running total calculation
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = 0; i < a.length; i++) {
            int index = nextIndex(a, min, i);
            aSorted[counts[index] - 1] = (Integer)a[i];
            counts[index]--;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = (T) aSorted[isAscending ? i : a.length - i - 1];
        }
    }
    private static <T> Integer nextIndex(T[] a, Integer min, int index) {
        return ((Integer)a[index]) - min;
    }
}
