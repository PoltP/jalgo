package com.jalgo.dynamicprogramming.test;

import static org.junit.Assert.assertEquals;

public interface CoinChangeCountTester {
    int test(int[] arr, int n);

    public static void test(CoinChangeCountTester tester, int expected1, int expected2) {
        assertEquals("[2, 3, 7] => 12", expected1, tester.test(new int[]{2, 3, 7}, 12));
        assertEquals("[2, 4, 6, 10] => 16", expected2, tester.test(new int[]{2, 4, 6, 10}, 16));
    }
}