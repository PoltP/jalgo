package com.jalgo.sorting.test;

import com.jalgo.sorting.HeapSort;
import com.jalgo.common.ISortable;

public class HeapSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new HeapSort<Integer>();
    }
}
