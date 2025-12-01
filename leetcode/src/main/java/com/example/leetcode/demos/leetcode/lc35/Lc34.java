package com.example.leetcode.demos.leetcode.lc35;

public class Lc34 {

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[2];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int left = mid;
                while (l >= 0 && nums[left] == target) {
                    res[0] = left;
                    l--;
                }
                int right = mid;
                while (r < nums.length && nums[right] == target) {
                    res[1] = right;
                    r++;
                }
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
