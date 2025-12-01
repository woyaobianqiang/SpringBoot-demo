package com.example.leetcode.demos.leetcode.lc1;

public class Lc11 {

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;

        for (int i = 0; i < height.length; i++) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, cur);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
