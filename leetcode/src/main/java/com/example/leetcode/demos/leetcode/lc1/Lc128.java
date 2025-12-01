package com.example.leetcode.demos.leetcode.lc1;

import java.util.HashSet;
import java.util.Set;

public class Lc128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int cur = 1;
                while (set.contains(num + 1)) {
                    cur++;
                    num++;
                }
                max = Math.max(max, cur);
            }
        }

        return max;
    }
}
