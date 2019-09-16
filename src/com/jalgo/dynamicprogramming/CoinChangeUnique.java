package com.jalgo.dynamicprogramming;

import java.util.HashMap;

public class CoinChangeUnique {
    public static int recursive(int coins[], int n) {
        return recursiveCore(coins, coins.length - 1, n);
    }
    public static int dpMemoization(int coins[], int n) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return dpMemoizationCore(coins, coins.length - 1, n, map);
    }
    private static int recursiveCore(int coins[], int coinIndex, int total) {
        if (total == 0)
            return 1;
        if (total < 0 || coinIndex < 0)
            return 0;
        return recursiveCore(coins, coinIndex - 1, total) +
                recursiveCore(coins, coinIndex - 1, total - coins[coinIndex]);
    }
    private static int dpMemoizationCore(int coins[], int coinIndex, int total,  HashMap<String, Integer> map) {
        String key = String.format("%d:%d", total, coinIndex);
        if(map.containsKey(key))
            return map.get(key);
        if (total == 0)
            return 1;
        if (total < 0 || coinIndex < 0)
            return 0;
        int value = dpMemoizationCore(coins, coinIndex - 1, total, map) +
                dpMemoizationCore(coins, coinIndex - 1, total - coins[coinIndex], map);
        map.put(key, value);
        return value;
    }
}
