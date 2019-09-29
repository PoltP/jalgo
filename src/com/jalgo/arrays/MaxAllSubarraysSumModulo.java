package com.jalgo.arrays;

import java.util.TreeSet;

public class MaxAllSubarraysSumModulo {
    //
    // sum(j+1, i) = (arr[j+1] + arr[j+2] + ... + arr[i]) % m, j <= i
    // prefix_i    = (arr[0]   + arr[1]   + ... + arr[j] + arr[j+1] + ... + arr[i]) % m
    // prefix_j    = (arr[0]   + arr[1]   + ... + arr[j]) % m
    //
    // => sum(j, i) = (prefix_i - prefix_j) % m = (m + prefix_i - prefix_j) % m
    //    to achieve max sum, prefix_j must be a first element which greater than prefix_i
    //    that's because I use TreeSet here
    public static long sum(long[] a, long m) {
        TreeSet<Long> prefixes = new TreeSet<Long>();
        long max = 0, prefix = 0;
        for (int i = 0; i < a.length; ++i) {
            prefix = (a[i] % m + prefix) % m;

            Long firstGreater = prefixes.higher(prefix);
            if (firstGreater != null) {
                max = Math.max(max, (prefix - firstGreater + m) % m);
            }
            max = Math.max(max, prefix);
            prefixes.add(prefix);
        }
        return max;
    }

    public static long bruteForce(long[] a, long m) {
        long max = 0;
        for (int i = 0; i < a.length; ++i) {
            long sum = 0;
            for (int j = i; j < a.length; ++j) {
                sum = (sum + a[j]) % m;
                max = Math.max(sum, max);
                if (max == m - 1) return max;// little optimization
            }
        }
        return max;
    }
}
