package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.MaxSumIncreasingSubsequence;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxSumIncreasingSubsequenceTest {
    @Test
    public void dpTabulation() {
        assertArrayEquals(new int[]{1, 12, 23, 52, 61, 69, 70}, MaxSumIncreasingSubsequence.dpTabulation(new int[]{1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2}));
        assertArrayEquals(new int[]{0, 8, 12, 14, 15}, MaxSumIncreasingSubsequence.dpTabulation(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
