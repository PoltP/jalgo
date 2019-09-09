package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import com.jalgo.sorting.BucketSort;

public class BucketSortTest extends BaseSortTest {
    protected ISortable<Integer> createSortable() {
        return new BucketSort(3);
    }
}
