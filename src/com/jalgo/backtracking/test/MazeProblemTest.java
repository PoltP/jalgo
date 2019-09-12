package com.jalgo.backtracking.test;

import com.jalgo.backtracking.MazeProblem;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MazeProblemTest {
    @Test
    public void Maze7x9() {
        int[][] maze = new int[][] {
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 0, 1 },
            { 1, 1, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 0, 0, 1, 0, 1 },
            { 0, 1, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 0, 0, 1, 0, 0 },
            { 1, 1, 0, 1, 1, 1, 1 }
        };
        MazeProblem mazeProblem = new MazeProblem();
        assertArrayEquals(new int[][] {
            { 1, 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 1, 1, 1 }
        }, mazeProblem.solve(maze));
    }
}
