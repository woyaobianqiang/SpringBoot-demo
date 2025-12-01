package com.example.leetcode.demos.leetcode;

import com.example.leetcode.demos.leetcode.lc94.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreePostOrder {

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        // 根 右 左 -> reverse
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            // root
            res.add(pop.val);

            // 左
            if (root.left != null) {
                stack.push(root.left);
            }

            // 右
            if (root.right != null) {
                stack.push(root.right);
            }
        }

        Collections.reverse(res);

        return res;
    }
}
