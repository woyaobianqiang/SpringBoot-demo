package com.example.leetcode.demos.web;

import java.util.HashSet;
import java.util.Set;

public class Lc1128 {


    // 定义一个字符串，找出连续不重复的最大子串
    public int solve(String s) {
        // abcdabcd
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            max = Math.max(max, set.size());
        }

        return max;
    }

    public static void main(String[] args) {
        Lc1128 lc1128 = new Lc1128();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int target = 7;
        boolean b = lc1128.binarySearch(nums, target);
        System.out.println(b);
    }

    // 用二分查找的方式查找某个数字是否在int数组
    public boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

}
