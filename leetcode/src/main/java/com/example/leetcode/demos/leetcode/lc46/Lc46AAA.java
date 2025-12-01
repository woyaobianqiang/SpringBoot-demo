package com.example.leetcode.demos.leetcode.lc46;

import java.util.ArrayList;
import java.util.List;

public class Lc46AAA {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            tmp.add(nums[i]);

            dfs(nums, used);

            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
