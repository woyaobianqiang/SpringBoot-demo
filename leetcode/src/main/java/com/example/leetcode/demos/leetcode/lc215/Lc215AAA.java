package com.example.leetcode.demos.leetcode.lc215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lc215AAA {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
