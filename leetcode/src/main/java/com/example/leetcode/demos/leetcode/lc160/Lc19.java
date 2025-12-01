package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

public class Lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur1 = head;
        while (cur1 != null) {
            size++;
            cur1 = cur1.next;
        }

        int i = size - n - 1;
        if (i < 0) {
            return head.next;
        }

        int loop = 0;
        ListNode cur2 = head;
        while (cur2 != null) {
            if (loop == i && cur2.next != null) {
                cur2.next = cur2.next.next;
            }
            cur2 = cur2.next;
            loop++;
        }

        return head;
    }


}
