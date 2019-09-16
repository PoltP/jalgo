package com.jalgo.dynamicprogramming;

import java.util.HashMap;

public class CoinChange {
    public static int recursive(int coins[], int n) {
        return recursiveCore(coins, coins.length, n);
    }
    public static int dpMemoization(int coins[], int n) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return dpMemoizationCore(coins, coins.length, n, map);
    }
    public static int dpTabulation(int[] coins, int n) {
        int[] dpTab = new int[n + 1];
        dpTab[0] = 1;
        for (int coin: coins) {
            for (int j = coin; j <= n; j++) {
                dpTab[j] += dpTab[j - coin];
            }
        }
        return dpTab[n];
    }
    private static int recursiveCore(int coins[], int coinIndex, int total) {
        if (total == 0)
            return 1;
        if (total < 0 || (total >= 1 && coinIndex == 0))
            return 0;
        return recursiveCore(coins, coinIndex - 1, total) +
                recursiveCore(coins, coinIndex, total - coins[coinIndex - 1]);
    }
    private static int dpMemoizationCore(int coins[], int coinIndex, int total,  HashMap<String, Integer> map) {
        String key = String.format("%d:%d", total, coinIndex);
        if(map.containsKey(key))
            return map.get(key);
        if (total == 0)
            return 1;
        if (total < 0 || (total >= 1 && coinIndex == 0))
            return 0;
        int value = dpMemoizationCore(coins, coinIndex - 1, total, map) +
                dpMemoizationCore(coins, coinIndex, total - coins[coinIndex - 1], map);
        map.put(key, value);
        return value;
    }
}
