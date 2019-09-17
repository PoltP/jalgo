package com.jalgo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int[] dpTabulation(int input[]) {
        int maxIndex = 0;
        int memo[] = new int[input.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && memo[i] < memo[j] + 1) {
                    memo[i] = memo[j] + 1;
                    if (memo[maxIndex] < memo[i]) {
                        maxIndex = i;
                    }
                }
            }
        }

        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(input[maxIndex]);
        int itemIndex = memo[maxIndex] - 1;
        for (int i = maxIndex; i >= 0; i--) {
            if (memo[i] == itemIndex) {
                sequence.add(input[i]);
                itemIndex--;
            }
        }
        Collections.reverse(sequence);
        return sequence.stream().mapToInt(item -> item).toArray();
    }
}
