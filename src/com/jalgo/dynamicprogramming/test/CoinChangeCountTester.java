package com.jalgo.dynamicprogramming.test;

import static org.junit.Assert.assertEquals;

public interface CoinChangeCountTester {
    int test(int[] arr, int n);

    static void test(CoinChangeCountTester tester, int expected1, int expected2, int expected3, int expected4) {
        assertEquals("[1, 2, 3] => 4", expected1, tester.test(new int[]{1, 2, 3}, 4));
        assertEquals("[2, 3, 7] => 12", expected2, tester.test(new int[]{2, 3, 7}, 12));
        assertEquals("[2, 5, 3, 6] => 10", expected3, tester.test(new int[]{2, 5, 3, 6}, 10));
        assertEquals("[6, 5, 3, 2] => 10", expected3, tester.test(new int[]{6, 5, 3, 2}, 10));
        assertEquals("[2, 4, 6, 10] => 16", expected4, tester.test(new int[]{2, 4, 6, 10}, 16));
        assertEquals("[6, 4, 2, 10] => 16", expected4, tester.test(new int[]{6, 4, 2, 10}, 16));
        assertEquals("[2, 4, 8] => 11", 0, tester.test(new int[]{2, 4, 8}, 11));
    }
}