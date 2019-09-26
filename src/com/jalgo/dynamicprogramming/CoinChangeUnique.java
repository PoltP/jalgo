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

    public static int dpTabulation(int[] coins, int n) {
        int coinCount = coins.length;
        // dpTab[i][j] > 0 when there are subsets of coins[0..j-1] with sum equal to i
        int dpTab[][] = new int[n + 1][coinCount + 1];

        for (int j = 0; j <= coinCount; j++)
            dpTab[0][j] = 1;// one subset with sum==0
        for (int i = 1; i <= n; i++)
            dpTab[i][0] = 0;// no empty subsets with sum!=0 (just to clarify)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= coinCount; j++) {
                int coin = coins[j - 1];
                // coin > current sum => take upper value
                // coin <= current sum => take upper value + previous value
                dpTab[i][j] = dpTab[i][j - 1] + (coin <= i ? dpTab[i - coin][j - 1] : 0);
            }
        }

        return dpTab[n][coinCount];
    }

    private static int recursiveCore(int coins[], int coinIndex, int total) {
        if (total == 0)
            return 1;
        if (total < 0 || coinIndex < 0)
            return 0;
        return recursiveCore(coins, coinIndex - 1, total) +
                recursiveCore(coins, coinIndex - 1, total - coins[coinIndex]);// coinIndex-1 - to NOT give a way to include it again
    }

    private static int dpMemoizationCore(int coins[], int coinIndex, int total, HashMap<String, Integer> map) {
        String key = String.format("%d:%d", total, coinIndex);
        if (map.containsKey(key))
            return map.get(key);
        if (total == 0)
            return 1;
        if (total < 0 || coinIndex < 0)
            return 0;
        int value = dpMemoizationCore(coins, coinIndex - 1, total, map) +
                dpMemoizationCore(coins, coinIndex - 1, total - coins[coinIndex], map);// coinIndex-1 - to NOT give a way to include it again
        map.put(key, value);
        return value;
    }
}
