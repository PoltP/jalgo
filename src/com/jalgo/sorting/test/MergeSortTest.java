package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.MergeSort;

public class MergeSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new MergeSort<Integer>();
    }
}
