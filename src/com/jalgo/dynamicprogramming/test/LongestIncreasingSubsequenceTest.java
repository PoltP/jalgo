package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.LongestIncreasingSubsequence;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void dpTabulation() {
        assertArrayEquals(new int[]{1, 7, 11, 31, 61, 69, 70}, LongestIncreasingSubsequence.dpTabulation(new int[]{1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2}));
        assertArrayEquals(new int[]{0, 2, 6, 9, 11, 15}, LongestIncreasingSubsequence.dpTabulation(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
