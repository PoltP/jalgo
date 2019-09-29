package com.jalgo.arrays.test;

import com.jalgo.arrays.MaxAllSubarraysSumModulo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAllSubarraysSumModuloTest {
    @Test
    public void sum() {
        long[] arr1 = new long[]{3, 3, 9, 9, 5};
        assertEquals(6, MaxAllSubarraysSumModulo.sum(arr1, 7));
        assertEquals(6, MaxAllSubarraysSumModulo.bruteForce(arr1, 7));
    }
}
