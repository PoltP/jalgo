package com.jalgo.backtracking.test;

import com.jalgo.backtracking.Subsets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class SubsetsTest {
    @Test
    public void powerSet() {
        List<ArrayList<Integer>> subsets = Subsets.powerSet(new int[]{1, 2, 3});
        int[][] powerSet = new int[subsets.size()][];
        for (int i = 0; i < subsets.size(); i++) {
            powerSet[i] = subsets.get(i).stream().mapToInt(item -> item).toArray();
        }
        assertArrayEquals(new int[][]{
            {1, 2, 3},
            {1, 2},
            {1, 3},
            {1},
            {2, 3},
            {2},
            {3},
            {}
        }, powerSet);
    }
}
