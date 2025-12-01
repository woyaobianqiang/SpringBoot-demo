package com.example.leetcode.demos.web;

import java.util.ArrayList;
import java.util.List;

public class Lc1120 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -3, 3, 4};
        int sum = 6;

        List<List<Integer>> solve = solve(nums, sum);
        System.out.println(solve);
    }

    public static List<List<Integer>> solve(int[] nums, int target) {
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int j = l; j <= i; j++) {
                    list.add(nums[j]);
                }
                // add res
                res.add(list);
                sum = 0;
                l = i;
            }
        }

        return res;
    }
}
