package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

public class Lc234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHead = reverseList(slow);
        while (head != null) {
            if (head.val != secHead.val) {
                return false;
            }
            head = head.next;
            secHead = secHead.next;
        }
        return true;
    }

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
