package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.CountingSort;
import com.jalgo.sorting.test.BaseSortTest;

public class CountingSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new CountingSort<Integer>();
    }
}
