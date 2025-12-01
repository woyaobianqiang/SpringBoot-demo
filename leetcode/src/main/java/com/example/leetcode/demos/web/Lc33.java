package com.example.leetcode.demos.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc33 {

    public static void main(String[] args) {
        //  [-1,0,1,2,-1,-4]
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Lc33 lc = new Lc33();
        System.out.println(lc.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int target = nums[i] + nums[l] + nums[r];
                if (target == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                } else if (target > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}
