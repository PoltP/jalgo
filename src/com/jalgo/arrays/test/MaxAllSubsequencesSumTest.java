package com.jalgo.arrays.test;

import com.jalgo.arrays.MaxAllSubsequencesSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAllSubsequencesSumTest {
    static final long[] arr1 = new long[]{2, -1, 2, 3, 4, -5};
    static final long[] arr2 = new long[]{-2, -3, -1, -4, -6};

    @Test
    public void sum() {
        assertEquals(11, MaxAllSubsequencesSum.sum(arr1));
        assertEquals(-1, MaxAllSubsequencesSum.sum(arr2));
    }
    @Test
    public void dpTabulation() {
        assertEquals(11, MaxAllSubsequencesSum.dpTabulation(arr1));
        assertEquals(-1, MaxAllSubsequencesSum.dpTabulation(arr2));
    }
    @Test
    public void recursive() {
        assertEquals(11, MaxAllSubsequencesSum.recursive(arr1));
        assertEquals(-1, MaxAllSubsequencesSum.recursive(arr2));
    }
}
