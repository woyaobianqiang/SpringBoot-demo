package com.example.leetcode.demos.leetcode.lc200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Lc207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> tos = new ArrayList<>();

        // init tos
        for (int i = 0; i < numCourses; i++) {
            tos.add(new ArrayList<>());
        }

        // init in tos
        for (int[] pre : prerequisites) {
            int to = pre[0];
            int from = pre[1];
            in[to]++;
            tos.get(from).add(to);
        }

        // 入队
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            Integer poll = q.poll();
            List<Integer> toList = tos.get(poll);
            for (Integer to : toList) {
                in[to]--;
                if (in[to] == 0) {
                    q.offer(to);
                }
            }
        }

        return count == numCourses;
    }
}
