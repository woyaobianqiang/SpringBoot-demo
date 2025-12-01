package com.example.leetcode.demos.leetcode.lc94;

import java.util.ArrayList;
import java.util.List;

public class Lc94AAA {

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
