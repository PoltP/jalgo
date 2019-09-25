package com.jalgo.dynamicprogramming;

import java.util.*;

public class CoinChangeMin {
    public static int[] dpTabulation(int[] coins, int n) {
        int[] usedCoins = new int[n + 1];
        int[] dpTab = new int[n + 1];
        Arrays.fill(dpTab, Integer.MAX_VALUE);
        dpTab[0] = 0;
        for (int coin: coins) {
            for (int j = coin; j <= n; j++) {
                if(dpTab[j - coin] + 1 < dpTab[j]) {
                    dpTab[j] = dpTab[j - coin] + 1;
                    usedCoins[j] = coin;
                }
            }
        }
        int minSequenceCount = dpTab[n];
        int[] minSequence = new int[minSequenceCount];
        for (int j = n, i = minSequenceCount - 1; i >= 0; i--) {
            minSequence[i] = usedCoins[j];
            j-= usedCoins[j];
        }
        return minSequence;
    }
}
