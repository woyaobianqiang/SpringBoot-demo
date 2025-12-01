package com.example.leetcode.demos.leetcode.lc1;

import java.util.HashSet;
import java.util.Set;

public class Lc41 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int num : nums) {
            if (num > 0 && num < Integer.MAX_VALUE) {
                set.add(num);
                max = Math.max(max, num);
            }
        }

        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }
}
