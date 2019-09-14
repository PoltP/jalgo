package com.jalgo.backtracking.test;

import com.jalgo.backtracking.NPartitions;
import org.junit.Test;

import static org.junit.Assert.*;

public class NPartitionsTest {
    @Test
    public void subsets3() {
        assertTrue(NPartitions.isPossible(new int[]{5, 2, 6, 3, 8}, 3));
        assertTrue(NPartitions.isPossible(new int[]{7, 1, 5, 2, 6}, 3));
        assertFalse(NPartitions.isPossible(new int[]{7, 1, 7, 3, 6}, 3));

        // Wont work with the negatives, cannot find subsets like {-5, 3, 8}, {6}, {9, -10, 7}, {3, 20, -17}
        // because firstly found subset {-5, 3, -10, 3, 7, 8} which is correct by sum
        //assertTrue(NPartitions.isPossible(new int[]{-5, 6, 9, 3, 20, -17, -10, 3, 7, 8}, 4));
    }
}