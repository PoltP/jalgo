package com.jalgo.arrays.test;

import com.jalgo.arrays.SubarraysWithOddNumbers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraysWithOddNumbersTest {
    static int[] test1 = new int[]{2, 4, 6, 8, 10, 1, 3};
    static int[] test2 = new int[]{4, 4, 7, 8, 9, 4, 15};

    @Test
    public void count() {
        assertEquals(7, SubarraysWithOddNumbers.count(test1, 1));
        assertEquals(6, SubarraysWithOddNumbers.count(test1, 2));
        assertEquals(8, SubarraysWithOddNumbers.count(test2, 2));
    }

    @Test
    public void bruteForce() {
        assertEquals(7, SubarraysWithOddNumbers.bruteForce(test1, 1));
        assertEquals(6, SubarraysWithOddNumbers.bruteForce(test1, 2));
        assertEquals(8, SubarraysWithOddNumbers.bruteForce(test2, 2));
    }
}
