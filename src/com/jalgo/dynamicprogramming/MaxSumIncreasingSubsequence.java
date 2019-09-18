package com.jalgo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSumIncreasingSubsequence {
    public static int[] dpTabulation(int input[]) {
        int maxIndex = 0;
        int memo[] = Arrays.copyOf(input, input.length);
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + input[i]);
                    if (memo[maxIndex] < memo[i]) {
                        maxIndex = i;
                    }
                }
            }
        }

        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = maxIndex, itemIndex = memo[maxIndex]; i >= 0; i--) {
            if (memo[i] == itemIndex) {
                sequence.add(input[i]);
                itemIndex -= input[i];
            }
        }
        Collections.reverse(sequence);
        return sequence.stream().mapToInt(item -> item).toArray();
    }
}
