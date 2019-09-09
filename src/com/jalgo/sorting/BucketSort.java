package com.jalgo.sorting;

import com.jalgo.common.ISortable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BucketSort implements ISortable<Integer> {
    private int number;

    public BucketSort(int number) {
        this.number = number;
    }
    public void sort(Integer[] a, Comparator<Integer> c) {
        Integer min = Arrays.stream(a).min(c).get();
        Integer max = Arrays.stream(a).max(c).get();
        boolean isAscending = max >= min;
        if(!isAscending) {
            Integer tmp = min;
            min = max;
            max = tmp;
        }
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[])new ArrayList[this.number];
        Integer length = max - min;
        for (int i = 0; i < a.length; i++) {
            int index = (int)Math.floor((this.number - 1) * (a[i] - min) / length);
            if(buckets[index] == null)
                buckets[index] = new ArrayList<Integer>();
            buckets[index].add(a[i]);
        }
        for (int i = 0; i < this.number; i++) {
            buckets[i].sort(c);
        }
        int index = 0;
        for (int i = 0; i < this.number; i++) {
            ArrayList<Integer> list = buckets[isAscending ? i : (this.number - i - 1)];
            for (int j = 0; j < list.size(); j++) {
                a[index++]= list.get(j);// already sorted above
            }
        }
    }
}