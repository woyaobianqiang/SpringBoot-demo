package com.example.leetcode.demos.leetcode.lc215;

import java.util.ArrayList;
import java.util.List;

public class Lc763 {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int end = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                start = i + 1;
                res.add(end - start + 1);
            }
        }

        return res;
    }
}
