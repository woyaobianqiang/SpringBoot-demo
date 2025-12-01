package com.example.leetcode.demos.web;

public class Lc1124 {

    public ListNode solve(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }

            ListNode next = end.next;
            end.next = null;

            ListNode curHead = prev.next;
            ListNode newHead = reverse(curHead);
            curHead.next = next;
            prev.next = newHead;
            prev = curHead;
        }
    }

    public ListNode reverse(ListNode head) {
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
