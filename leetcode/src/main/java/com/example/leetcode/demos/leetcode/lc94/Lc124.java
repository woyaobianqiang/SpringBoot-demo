package com.example.leetcode.demos.leetcode.lc94;

public class Lc124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lH = Math.max(0, dfs(root.left));
        int rH = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + lH + rH);
        return root.val + Math.max(lH, rH);
    }
}
