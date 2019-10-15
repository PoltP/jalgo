package com.jalgo.arrays;

public class MaxSubarraySum {
    public static long sumKadane(long[] arr) {
        long currentSum = 0l, maxSum = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static long sumDP(long[] arr) {
        long maxSum = Long.MIN_VALUE;
        long[] memo = new long[arr.length + 1];
        memo[0] = arr[0];
        // memo(i) is the maximum sum ending at index “i”,
        // there are two options:
        // 1) ADD previous sum that has been found before index “i” (till index “i-1“);
        // 2) START a new sum from the index “i“
        for (int i = 1; i < arr.length; i++) {
            memo[i] = Math.max(arr[i], memo[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, memo[i]);
        }
        return maxSum;
    }
}
