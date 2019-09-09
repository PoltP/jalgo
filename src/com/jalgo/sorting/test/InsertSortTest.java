package com.jalgo.sorting.test;

import com.jalgo.sorting.InsertSort;
import com.jalgo.common.ISortable;

public class InsertSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new InsertSort<Integer>();
    }
}
