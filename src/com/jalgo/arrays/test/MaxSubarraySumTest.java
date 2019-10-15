package com.jalgo.arrays.test;

import com.jalgo.arrays.MaxSubarraySum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubarraySumTest {
    static final long[] arr1 = new long[]{2, -1, 2, 3, 4, -5};
    static final long[] arr2 = new long[]{-2, -3, -1, -4, -6};

    @Test
    public void sumKadane() {
        assertEquals(10, MaxSubarraySum.sumKadane(arr1));
        assertEquals(-1, MaxSubarraySum.sumKadane(arr2));
    }

    @Test
    public void sumDP() {
        assertEquals(10, MaxSubarraySum.sumDP(arr1));
        assertEquals(-1, MaxSubarraySum.sumDP(arr2));
    }
}
