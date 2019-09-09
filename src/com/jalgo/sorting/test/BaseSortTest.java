package com.jalgo.sorting.test;

import com.jalgo.common.ISortable;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class BaseSortTest {
    protected abstract ISortable<Integer> createSortable();
    private Integer[] createIntegerArray() {
        return new Integer[] { 30, -70, 90, 10, -5, 80, 60, -100, 60 };
    }
    private Integer[] getAscendingIntegerArray() {
        return new Integer[] { -100, -5, 10, 30, 60, 60, -70, 80, 90 };
    }
    private Integer[] getDescendingIntegerArray() {
        return new Integer[] { 90, 80, -70, 60, 60, 30, 10, -5, -100 };
    }

    @Test
    public void sortAscending() {
        ISortable<Integer> sortable = this.createSortable();
        Integer[] arr = this.createIntegerArray();
        sortable.sort(arr, (a, b) -> Integer.compare(a, b));
        assertArrayEquals("Ascending (Integer)", this.getAscendingIntegerArray(), arr);
    }
    @Test
    public void sortDescending() {
        ISortable<Integer> sortable = this.createSortable();
        Integer[] arr = this.createIntegerArray();
        sortable.sort(arr, (a, b) -> Integer.compare(b, a));
        assertArrayEquals("Descending (Integer)", this.getDescendingIntegerArray(), arr);
    }
}
