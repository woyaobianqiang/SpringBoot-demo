package com.example.leetcode.demos.leetcode.lc46;


import java.util.*;

public class Lc51 {

    List<List<String>> res = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> addSet = new HashSet<>();
    Set<Integer> subSet = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (char[] chars : grid) {
            Arrays.fill(chars, '.');
        }
        dfs(grid, n, 0);
        return res;
    }

    public void dfs(char[][] grid, int n, int r) {
        if (r == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] chars : grid) {
                tmp.add(new String(chars));
            }
            res.add(tmp);
        }

        for (int c = 0; c < n; c++) {
            if (colSet.contains(c) || addSet.contains(r + c) || subSet.contains(r - c)) {
                continue;
            }

            grid[r][c] = 'Q';
            colSet.add(c);
            addSet.add(r + c);
            subSet.add(r - c);

            dfs(grid, n, r + 1);

            grid[r][c] = '.';
            colSet.remove(c);
            addSet.remove(r + c);
            subSet.remove(r - c);
        }
    }
}
