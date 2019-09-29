package com.jalgo.arrays;

import java.util.Arrays;

public class MaxAllSubsequencesSum {
    public static long sum(long[] arr) {
        long[] seqSums = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                seqSums[i] = arr[i];
            } else {
                if (seqSums[i - 1] < 0 || arr[i] < 0) {
                    seqSums[i] = Math.max(seqSums[i - 1], arr[i]);
                } else {
                    seqSums[i] = Math.max(seqSums[i - 1], arr[i] + seqSums[i - 1]);
                }
            }
        }
        return seqSums[seqSums.length - 1];
    }

    public static long dpTabulation(long[] arr) {
        long[] seqSums = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                seqSums[i] = Math.max(seqSums[i], arr[i] + seqSums[j]);
            }
        }
        return Arrays.stream(seqSums).max().getAsLong();
    }

    public static long recursive(long[] arr) {
        long[] seqSums = new long[arr.length];
        Arrays.fill(seqSums, Long.MIN_VALUE);
        return recursiveCore(arr, arr.length - 1, seqSums);
    }

    private static long recursiveCore(long[] arr, int i, long[] seqSums) {
        if (seqSums[i] != Long.MIN_VALUE) return seqSums[i];
        long result;
        if (i == 0) {
            result = arr[i];
        } else {
            long prev = recursiveCore(arr, i - 1, seqSums);
            if (prev < 0 || arr[i] < 0) {
                result = Math.max(prev, arr[i]);
            } else {
                result = Math.max(prev, arr[i] + prev);
            }
        }
        seqSums[i] = result;
        return result;
    }
}
