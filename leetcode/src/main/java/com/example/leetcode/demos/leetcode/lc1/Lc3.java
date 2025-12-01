package com.example.leetcode.demos.leetcode.lc1;

import java.util.HashSet;
import java.util.Set;

public class Lc3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            r++;
            max = Math.max(max, set.size());
        }

        return max;
    }
}
