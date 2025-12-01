package com.example.leetcode.demos.leetcode.lc215;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc295 {

    class MedianFinder {
        Queue<Integer> big;
        Queue<Integer> small;

        public MedianFinder() {
            big = new PriorityQueue<>(Collections.reverseOrder());
            small = new PriorityQueue<>();
        }

        public void addNum(int num) {
            big.offer(num);
            small.offer(big.poll());
            if (small.size() > big.size()) {
                big.offer(small.poll());
            }
        }

        public double findMedian() {
            if (small.size() > big.size()) {
                return small.peek();
            }
            if (small.size() < big.size()) {
                return big.peek();
            }
            return (small.peek() + big.peek()) / 2.0;
        }
    }
}
