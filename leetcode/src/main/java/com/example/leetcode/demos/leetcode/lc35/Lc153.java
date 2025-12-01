package com.example.leetcode.demos.leetcode.lc35;

public class Lc153 {

    public int findMin(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur < nums[i]) {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
