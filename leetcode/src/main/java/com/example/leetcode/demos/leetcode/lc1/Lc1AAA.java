package com.example.leetcode.demos.leetcode.lc1;

import java.util.HashMap;
import java.util.Map;

public class Lc1AAA {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                res[0] = map.get(diff);
                res[1] = i;
            }
        }

        return res;
    }
}
