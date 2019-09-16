package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.CoinChangeMin;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CoinChangeMinTest {
    @Test
    public void dpTabulation() {
        assertArrayEquals(new int[]{6, 10}, CoinChangeMin.dpTabulation(new int[]{2, 4, 6, 10}, 16));
    }
}