package com.example.leetcode.demos.leetcode.lc35;

public class Lc74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
