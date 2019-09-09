package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.QuickHoareSort;

public class QuickHoareSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new QuickHoareSort<Integer>();
    }
}
