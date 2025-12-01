package com.example.leetcode.demos.leetcode.lc1;

import java.util.*;

public class Lc56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] prev = res.get(res.size() - 1);
            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[0], cur[0]);
            } else {
                res.add(cur);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
