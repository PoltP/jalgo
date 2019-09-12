package com.jalgo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensProblem {
    public List<int[]> solve(int number) {
        List<int[]> placements = new ArrayList<int[]>();
        int[] columns = new int[number];
        Arrays.fill(columns, -1);
        solveCore(placements, columns, 0, number);
        return placements;
    }

    private static void solveCore(List<int[]> placements, int[] columns, int row, int n) {
        if(row >= n) {
            placements.add(columns);
            return;
        }
        for (int column = 0; column < n; column++) {
            if(isSafe(columns, column, row)) {
                int[] newColumns = Arrays.copyOf(columns, columns.length);
                newColumns[row] = column;
                solveCore(placements, newColumns, row + 1, n);
            }
        }
    }
    private static boolean isSafe(int[] columns, int column, int row) {
        for (int i = 0; i < row; i++) {
            if(columns[i] == column || Math.abs(column - columns[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }
}
