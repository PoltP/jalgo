package com.jalgo.arrays.test;

import com.jalgo.arrays.MaxAllSubarraysSumKadane;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAllSubarraysSumKadaneTest {
    @Test
    public void sum() {
        assertEquals(10, MaxAllSubarraysSumKadane.sum(new long[]{2, -1, 2, 3, 4, -5}));
        assertEquals(-1, MaxAllSubarraysSumKadane.sum(new long[]{-2, -3, -1, -4, -6}));
    }
}
