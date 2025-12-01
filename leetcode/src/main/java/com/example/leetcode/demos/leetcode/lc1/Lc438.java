package com.example.leetcode.demos.leetcode.lc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pArr, sArr)) {
            res.add(0);
        }

        int pLen = p.length();
        for (int i = pLen; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(i - pLen) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                res.add(i - pLen + 1);
            }
        }

        return res;
    }
}
