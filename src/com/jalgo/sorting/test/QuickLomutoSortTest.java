package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.QuickLomutoSort;

public class QuickLomutoSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new QuickLomutoSort<Integer>();
    }
}
