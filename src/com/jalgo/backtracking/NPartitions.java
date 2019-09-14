package com.jalgo.backtracking;
import java.util.stream.IntStream;

/*
   Partition of a set into 'number' subsets with equal sum
*/
public class NPartitions {
    public static boolean isPossible(int set[], int number) {
        if (number == 1)
            return true;
        int count = set.length;
        if (count < number)
            return false;

        int setSum = IntStream.of(set).sum();
        if (setSum % number != 0)
            return false;

        return isPossibleCore(set, new boolean[count], setSum / number, 0, number, 0);
    }

    private static boolean isPossibleCore(int set[], boolean included[], int subsetSum, int currentSum, int number, int index) {
        if(number == 1) {
            return true;
        }
        if (currentSum == subsetSum) {
            return isPossibleCore(set, included, subsetSum, 0, number - 1, 0);
        }

        for (int i = index; i < set.length; i++) {
            if (included[i] || currentSum + set[i] > subsetSum) continue;
            included[i] = true;
            if (isPossibleCore(set, included, subsetSum, currentSum + set[i], number, i + 1)) {
                return true;
            }
            included[i] = false;
        }
        return false;
    }
}