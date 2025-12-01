package com.example.leetcode.demos.leetcode.lc46;

public class Lc79 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        char tmp = board[r][c];
        board[r][c] = '#';

        boolean res = dfs(board, r + 1, c, word, index + 1) ||
                dfs(board, r - 1, c, word, index + 1) ||
                dfs(board, r, c + 1, word, index + 1) ||
                dfs(board, r, c - 1, word, index + 1);

        board[r][c] = tmp;

        return res;
    }
}
