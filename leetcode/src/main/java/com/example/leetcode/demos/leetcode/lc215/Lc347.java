package com.example.leetcode.demos.leetcode.lc215;

import java.util.*;

public class Lc347 {

    public int[] topKFrequent(int[] nums, int k) {
        // num freq
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[nums.length];
        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }
}
