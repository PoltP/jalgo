package com.jalgo.sorting.test;

import com.jalgo.sorting.SelectionSort;
import com.jalgo.common.ISortable;

public class SelectionSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new SelectionSort<Integer>();
    }
}
