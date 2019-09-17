package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.Knapsack;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class KnapsakTest {
    @Test
    public void dpMemoization() {
        assertArrayEquals(new int[] {1, 3}, Knapsack.dpMemoization(new int[] {60, 50, 70, 30}, new int[] {5, 3, 4, 2}, 5));
        assertArrayEquals(new int[] {0, 1, 2, 3}, Knapsack.dpMemoization(new int[] {5, 3, 5, 3, 2}, new int[] {1, 2, 4, 2, 5},10));
        // There are 2 solutions with the cost 70: {0, 3, 4} & {2, 4}
        assertArrayEquals(new int[] {0, 3, 4}, Knapsack.dpMemoization(new int[] {15, 10, 40, 25, 30}, new int[] {50, 40, 70, 30, 25}, 120));
    }
    @Test
    public void dpTabulation() {
        assertArrayEquals(new int[] {1, 3}, Knapsack.dpMemoization(new int[] {60, 50, 70, 30}, new int[] {5, 3, 4, 2}, 5));
        assertArrayEquals(new int[] {0, 1, 2, 3}, Knapsack.dpMemoization(new int[] {5, 3, 5, 3, 2}, new int[] {1, 2, 4, 2, 5},10));
        // There are 2 solutions with the cost 70: {0, 3, 4} & {2, 4}
        assertArrayEquals(new int[] {0, 3, 4}, Knapsack.dpTabulation(new int[] {15, 10, 40, 25, 30}, new int[] {50, 40, 70, 30, 25}, 120));
    }
}
