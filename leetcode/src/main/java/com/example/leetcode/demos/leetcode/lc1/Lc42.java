package com.example.leetcode.demos.leetcode.lc1;

public class Lc42 {

    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max(left[i], right[i]) - height[i];
        }

        return sum;
    }
}
