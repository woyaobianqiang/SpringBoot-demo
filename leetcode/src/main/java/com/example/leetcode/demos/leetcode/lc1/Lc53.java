package com.example.leetcode.demos.leetcode.lc1;

public class Lc53 {

    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (cur < nums[i]) {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}
