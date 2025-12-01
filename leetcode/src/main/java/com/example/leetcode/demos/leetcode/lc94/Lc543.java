package com.example.leetcode.demos.leetcode.lc94;

public class Lc543 {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lH = dfs(root.left);
        int rH = dfs(root.right);
        max = Math.max(max, lH + rH);
        return Math.max(lH, rH) + 1;
    }
}
