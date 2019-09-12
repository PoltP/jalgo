package com.jalgo.backtracking.test;

import com.jalgo.backtracking.NQueensProblem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NQueensProblemTest {
    @Test
    public void Queens4() {
        NQueensProblem nQueens = new NQueensProblem();
        List<int[]> placements = nQueens.solve(4);
        assertEquals("2 distinct solutions", 2, placements.size());
        assertArrayEquals(new int[]{ 1, 3, 0, 2 }, placements.get(0));
        assertArrayEquals(new int[]{ 2, 0, 3, 1 }, placements.get(1));
    }
    @Test
    public void Queens8() {
        NQueensProblem nQueens = new NQueensProblem();
        List<int[]> placements = nQueens.solve(8);
        assertEquals("92 distinct solutions", 92, placements.size());
        assertArrayEquals(new int[]{ 5, 3, 6, 0, 2, 4, 1, 7 }, placements.get(77));
    }
}
