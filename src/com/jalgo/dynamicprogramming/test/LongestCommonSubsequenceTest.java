package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.LongestCommonSubsequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    @Test
    public void dpMemoization() {
        assertEquals(3, LongestCommonSubsequence.dpMemoization("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "PAVEL"));
        assertEquals(13, LongestCommonSubsequence.dpMemoization("The only thing we have to fear is fear itself", "thing is fear"));
    }
}
