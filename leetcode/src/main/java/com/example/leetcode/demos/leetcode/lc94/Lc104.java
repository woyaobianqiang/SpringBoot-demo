package com.example.leetcode.demos.leetcode.lc94;

public class Lc104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lH = maxDepth(root.left);
        int rH = maxDepth(root.right);
        return Math.max(lH, rH) + 1;
    }
}
