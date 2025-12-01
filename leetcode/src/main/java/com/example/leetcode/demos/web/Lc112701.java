package com.example.leetcode.demos.web;

import java.util.HashMap;
import java.util.Map;

public class Lc112701 {

    public static int solve(int[] nums) {
        int max = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (cur < nums[i]) {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int solve = solve(nums);
        System.out.println(solve);
    }

    public Map<Integer, Integer> red(int people, int total) {
        Map<Integer, Integer> map = new HashMap<>();

        while (people > 0) {
            int random = 1;
            // 一直生成直到满足生成的红包值小于当前总额
            while (true) {
                random = random();
                if (random < total) {
                    break;
                }
            }
            // 分配
            map.put(people, random);
            total = total - random;
            people--;
        }

        return map;
    }

    public int random() {
        return 1;
    }
}
