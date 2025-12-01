package com.example.leetcode.demos.leetcode.lc200;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lc994 {

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty() && fresh > 0) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                for (int[] dir : dirs) {
                    int r = poll[0] + dir[0];
                    int c = poll[1] + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n) {
                        continue;
                    }
                    if (grid[r][c] != 1) {
                        continue;
                    }
                    fresh--;
                    grid[r][c] = 2;
                    q.offer(new int[]{r, c});
                }
            }
        }

        return fresh == 0 ? count : -1;
    }
}
