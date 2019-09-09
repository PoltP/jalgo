package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.HeapSortEx;

public class HeapSortExTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new HeapSortEx<Integer>();
    }
}
