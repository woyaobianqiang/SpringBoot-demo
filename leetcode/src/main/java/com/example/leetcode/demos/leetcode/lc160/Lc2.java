package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dmy = new ListNode(0);
        ListNode cur = dmy;

        while (carry != 0 || l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int newSum = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(newSum);
            cur.next = newNode;
            cur = cur.next;
        }

        return dmy.next;
    }
}
