package com.example.leetcode.demos.leetcode.lc46;

import java.util.ArrayList;
import java.util.List;

public class Lc39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);

            dfs(candidates, target - candidates[i], i);

            tmp.remove(tmp.size() - 1);
        }
    }
}
