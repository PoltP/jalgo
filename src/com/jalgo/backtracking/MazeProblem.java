package com.jalgo.backtracking;

public class MazeProblem {
    public int[][] solve(int maze[][]) {
        if(maze.length == 0) return null;
        int[][] path = new int[maze.length][maze[0].length];
        solveCore(maze, 0, 0, path);
        return path;
    }

    private static boolean solveCore(int maze[][], int x, int y, int path[][]) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            path[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            path[x][y] = 1;

            if (solveCore(maze, x + 1, y, path))
                return true;
            if (solveCore(maze, x, y + 1, path))
                return true;

            path[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int maze[][], int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }
}
