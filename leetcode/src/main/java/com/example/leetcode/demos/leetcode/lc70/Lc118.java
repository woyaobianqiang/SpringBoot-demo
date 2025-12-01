package com.example.leetcode.demos.leetcode.lc70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);

            List<Integer> prev = res.get(res.size() - 1);
            for (int j = 1; j < prev.size(); j++) {
                tmp.add(prev.get(j - 1) + prev.get(j));
            }

            tmp.add(1);
            res.add(tmp);
        }

        return res;
    }

    
}
