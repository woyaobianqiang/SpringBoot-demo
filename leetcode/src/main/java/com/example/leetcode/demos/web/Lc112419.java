package com.example.leetcode.demos.web;

import java.util.HashSet;
import java.util.Set;

public class Lc112419 {

    public static void main(String[] args) {
        String s = "abcd";
        Lc112419 l = new Lc112419();
        System.out.println(l.solve(s));
    }

    public int solve(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int r = 0;
        int l = 0;
        int len = s.length();
        while (r < len) {
            // 去重
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            // 计算长度
            set.add(s.charAt(r));
            max = Math.max(max, set.size());
            r++;
        }

        return max;
    }


}
