package com.example.leetcode.demos.leetcode.lc62;

public class Lc5 {

    int max = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(start, start + max);
    }

    public void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        int cur = r - l - 1;
        if (cur > max) {
            max = cur;
            start = l + 1;
        }
    }
}
