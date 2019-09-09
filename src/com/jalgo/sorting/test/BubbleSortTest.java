package com.jalgo.sorting.test;

import com.jalgo.sorting.BubbleSort;
import com.jalgo.common.ISortable;

public class BubbleSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new BubbleSort<Integer>();
    }
}
