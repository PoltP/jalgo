package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.CoinChange;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void recursive() {
        CoinChangeCountTester.test((arr, n) -> CoinChange.recursive(arr, n), 4, 4, 5, 13);
    }

    @Test
    public void dpTabulation() {
        CoinChangeCountTester.test((arr, n) -> CoinChange.dpTabulation(arr, n), 4, 4, 5, 13);
    }

    @Test
    public void dpMemoization() {
        CoinChangeCountTester.test((arr, n) -> CoinChange.dpMemoization(arr, n), 4, 4, 5, 13);
    }
}
