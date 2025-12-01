package com.example.leetcode.demos.leetcode.lc136;

public class Lc136AAA {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
