package com.example.leetcode.demos.leetcode.lc46;

import java.util.ArrayList;
import java.util.List;

public class Lc22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return res;
    }

    public void dfs(int n, int l, int r, String tmp) {
        if (tmp.length() == n * 2) {
            res.add(tmp);
            return;
        }

        if (l < n) {
            dfs(n, l + 1, r, tmp + '(');
        }
        if (r < l) {
            dfs(n, l, r + 1, tmp + ')');
        }
    }
}
