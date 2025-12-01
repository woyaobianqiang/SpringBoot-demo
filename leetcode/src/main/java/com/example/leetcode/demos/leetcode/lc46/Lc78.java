package com.example.leetcode.demos.leetcode.lc46;

import java.util.ArrayList;
import java.util.List;

public class Lc78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);

            dfs(nums, i + 1);

            tmp.remove(tmp.size() - 1);
        }
    }
}
