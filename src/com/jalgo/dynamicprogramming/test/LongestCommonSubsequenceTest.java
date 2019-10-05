package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.LongestCommonSubsequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    static String[] test1 = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "PAVEL"};
    static String[] test2 = new String[]{"The only thing we have to fear is fear itself", "thing is fear"};

    @Test
    public void dpMemoization() {
        assertEquals(3, LongestCommonSubsequence.dpMemoization(test1[0], test1[1]));
        assertEquals(13, LongestCommonSubsequence.dpMemoization(test2[0], test2[1]));
    }

    @Test
    public void dpTabulation() {
        assertEquals(3, LongestCommonSubsequence.dpTabulation(test1[0], test1[1]));
        assertEquals(13, LongestCommonSubsequence.dpTabulation(test2[0], test2[1]));
    }
}
