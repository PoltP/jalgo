package com.jalgo.other.test;

import com.jalgo.other.QuickSelect;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class QuickSelectTest {
    final Integer[] testArray = new Integer[]{30, -70, 90, 10, -5, 80, 60, -100, 60};

    @Test
    public void lomuto() {
        assertEquals(80, (int) QuickSelect.findKthSmallestLomuto(testArray, (a, b) -> Integer.compare(a, b), 2, 6, 3));
        assertEquals(-5, (int) QuickSelect.findKthSmallestLomuto(testArray, (a, b) -> Integer.compare(a, b), 0, testArray.length - 1, 2));
    }

    @Test
    public void hoare() {
        assertEquals(80, (int) QuickSelect.findKthSmallestHoare(testArray, (a, b) -> Integer.compare(a, b), 2, 6, 3));
        assertEquals(-5, (int) QuickSelect.findKthSmallestLomuto(testArray, (a, b) -> Integer.compare(a, b), 0, testArray.length - 1, 2));
    }
}
