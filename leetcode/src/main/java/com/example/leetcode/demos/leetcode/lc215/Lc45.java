package com.example.leetcode.demos.leetcode.lc215;

public class Lc45 {

    public int jump(int[] nums) {
        int next = 0;
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) {
                cur = next;
                count++;
            }
        }

        return count;
    }
}
