package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc23 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        for (ListNode node : lists) {
            while (node != null) {
                q.offer(node);
                node = node.next;
            }
        }

        ListNode dmy = new ListNode(0);
        ListNode cur = dmy;
        while (!q.isEmpty()) {
            ListNode poll = q.poll();
            poll.next = null;
            cur.next = poll;
            cur = cur.next;
        }

        return dmy.next;
    }
}
