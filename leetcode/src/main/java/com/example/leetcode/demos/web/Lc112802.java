package com.example.leetcode.demos.web;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lc112802 {

    public int solve(int[] nums) {
        // 9788
        int len = nums.length;
        int max = arrToNum(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(nums, i, j);
                int cur = arrToNum(nums);
                max = Math.max(max, cur);
            }
        }

        return max;
    }

    // 从数组转成数字
    public int arrToNum(int[] nums) {
        return 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        PriorityQueue<Object> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(9);
        q.offer(7);
        q.offer(8);
        q.offer(8);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
