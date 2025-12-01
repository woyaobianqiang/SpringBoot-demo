package com.example.leetcode.demos.leetcode.lc20;

import java.util.Arrays;
import java.util.Stack;

public class Lc84 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, -1);
        Arrays.fill(right, len);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                Integer pop = stack.pop();
                right[pop] = i;
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }

        return max;
    }
}
