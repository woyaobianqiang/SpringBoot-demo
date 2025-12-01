package com.example.leetcode.demos.leetcode.lc1;

public class Lc283 {

    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[l] == 0 && nums[r] != 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
            if (nums[l] != 0) {
                l++;
            }

            r++;
        }
    }
}
