package com.example.leetcode.demos.leetcode.lc20;

import java.util.Stack;

public class Lc155 {

    class MinStack {

        private Stack<Integer> data;
        private Stack<Integer> min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }

        public void pop() {
            Integer pop = data.pop();
            if (!min.isEmpty() && pop <= min.peek()) {
                min.pop();
            }
        }

        public int top() {
            return data.isEmpty() ? -1 : data.peek();
        }

        public int getMin() {
            return min.isEmpty() ? -1 : min.peek();
        }
    }
}
