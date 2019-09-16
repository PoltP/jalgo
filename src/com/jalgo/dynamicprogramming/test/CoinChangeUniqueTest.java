package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.CoinChangeUnique;
import org.junit.Test;

public class CoinChangeUniqueTest {
    @Test
    public void recursive() {
        CoinChangeCountTester.test((arr, n) -> CoinChangeUnique.recursive(arr, n), 1, 2);
    }
    @Test
    public void dpMemoization() {
        CoinChangeCountTester.test((arr, n) -> CoinChangeUnique.dpMemoization(arr, n), 1, 2);
    }
}
