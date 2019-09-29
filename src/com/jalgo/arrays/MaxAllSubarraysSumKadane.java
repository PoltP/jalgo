package com.jalgo.arrays;

public class MaxAllSubarraysSumKadane {
    public static long sum(long[] arr) {
        long currentSum = 0l, maxSum = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
