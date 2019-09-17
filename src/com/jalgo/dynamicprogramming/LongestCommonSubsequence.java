package com.jalgo.dynamicprogramming;

public class LongestCommonSubsequence {
    public static int dpMemoization(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return dpMemoizationCore(memo, s1, s2, s1.length(), s2.length());
    }

    private static int dpMemoizationCore(int[][] memo, String s1, String s2, int count1, int count2) {
        if (memo[count1][count2] != 0)
            return memo[count1][count2];
        int max;
        if (count1 == 0 || count2 == 0) {
            max = 0;
        } else if (s1.charAt(count1 - 1) == s2.charAt(count2 - 1)) {
            max = 1 + dpMemoizationCore(memo, s1, s2, count1 - 1, count2 - 1);
        } else {
            max = Math.max(dpMemoizationCore(memo, s1, s2, count1 - 1, count2), dpMemoizationCore(memo, s1, s2, count1, count2 - 1));
        }
        return memo[count1][count2] = max;
    }
}
