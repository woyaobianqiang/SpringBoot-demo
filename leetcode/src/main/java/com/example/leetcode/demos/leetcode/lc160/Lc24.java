package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

public class Lc24 {

    public ListNode swapPairs(ListNode head) {
        int k = 2;
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode prev = dmy;
        while (true) {
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dmy.next;
                }
            }

            ListNode next = end.next;
            end.next = null;

            ListNode curHead = prev.next;
            ListNode newHead = reverseList(curHead);
            curHead.next = next;
            prev.next = newHead;
            prev = curHead;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(0);
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
