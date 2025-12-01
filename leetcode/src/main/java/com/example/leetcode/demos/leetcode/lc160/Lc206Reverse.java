package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

public class Lc206Reverse {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
