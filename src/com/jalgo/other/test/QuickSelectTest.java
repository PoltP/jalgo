package com.jalgo.other.test;

import com.jalgo.other.QuickSelect;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class QuickSelectTest {
    static Integer[] getTestArray() {
        return new Integer[]{30, -70, 90, 10, -5, 80, 60, -100, 60};
    }

    @Test
    public void lomuto() {
        assertEquals(80, (int) QuickSelect.findKthSmallestLomuto(getTestArray(), (a, b) -> Integer.compare(a, b), 2, 6, 3));
        assertEquals(-5, (int) QuickSelect.findKthSmallestLomuto(getTestArray(), (a, b) -> Integer.compare(a, b), 0, getTestArray().length - 1, 2));
    }

    @Test
    public void hoare() {
        assertEquals(80, (int) QuickSelect.findKthSmallestHoare(getTestArray(), (a, b) -> Integer.compare(a, b), 2, 6, 3));
        assertEquals(-5, (int) QuickSelect.findKthSmallestHoare(getTestArray(), (a, b) -> Integer.compare(a, b), 0, getTestArray().length - 1, 2));
    }
}
