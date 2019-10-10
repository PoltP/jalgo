package com.jalgo.arrays;

public class SubarraysWithOddNumbers {
    public static int count(int[] a, int m) {
        int result = 0;
        int subarrayCounts[] = new int[a.length];
        for (int i = 0, oddCount = 0; i < a.length; ++i) {
            subarrayCounts[oddCount]++;

            if (a[i] % 2 != 0) {
                oddCount++;
            }

            if (oddCount >= m) {
                result += subarrayCounts[oddCount - m];
            }
        }
        return result;
    }

    public static int bruteForce(int a[], int m) {
        int result = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = i, oddCount = 0; j < a.length; ++j) {
                if (a[j] % 2 == 0) {
                    oddCount++;
                }
                if (oddCount == m) {
                    result++;
                } else if (oddCount > m) {
                    break;
                }
            }
        }
        return result;
    }
}
