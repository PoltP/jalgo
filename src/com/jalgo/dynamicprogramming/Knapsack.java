package com.jalgo.dynamicprogramming;

import java.util.HashSet;

public class Knapsack {
    public static int[] dpMemoization(int[] v, int[] w, int C) {
        int n = v.length;
        if (n != w.length)
            throw new IllegalArgumentException("Incorrect values/weights length");
        int[][] memo = new int[n][C + 1];
        dpMemoizationCore(memo, v, w, n - 1, C);
        return extractItemIndexes(memo, v, w, C);
    }

    public static int[] dpTabulation(int[] v, int[] w, int C) {
        int n = v.length;
        if (n != w.length)
            throw new IllegalArgumentException("Incorrect values/weights length");
        int[][] memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0) {
                    memo[i][j] = j >= w[i] ? v[i] : 0;
                } else {
                    memo[i][j] = j >= w[i] ? Math.max(memo[i - 1][j], v[i] + memo[i - 1][j - w[i]]) : memo[i - 1][j];
                }
            }
        }
        return extractItemIndexes(memo, v, w, C);
    }

    private static int dpMemoizationCore(int[][] memo, int[] v, int[] w, int index, int C) {
        if (index < 0)
            return 0;
        if (memo[index][C] != 0)
            return memo[index][C];
        int max;
        if (C == 0) {
            max = 0;
        } else if (w[index] > C) {
            max = dpMemoizationCore(memo, v, w, index - 1, C);
        } else {
            max = Math.max(dpMemoizationCore(memo, v, w, index - 1, C), v[index] + dpMemoizationCore(memo, v, w, index - 1, C - w[index]));
        }
        return memo[index][C] = max;
    }

    private static int[] extractItemIndexes(int[][] memo, int[] v, int[] w, int C) {
        HashSet<Integer> indexes = new HashSet<>();
        for (int i = v.length - 1, j = C; i >= 0; i--) {
            if (j >= w[i] && (memo[i][j] - v[i] == (i == 0 ? 0 : memo[i - 1][j - w[i]]))) {
                indexes.add(i);
                j -= w[i];
            }
        }
        return indexes.stream().mapToInt(item -> item).toArray();
    }
}
