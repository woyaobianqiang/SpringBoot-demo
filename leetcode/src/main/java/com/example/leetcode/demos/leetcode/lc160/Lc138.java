package com.example.leetcode.demos.leetcode.lc160;

import com.example.leetcode.demos.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

public class Lc138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur1 = head;
        while (cur1 != null) {
            map.put(cur1, new Node(cur1.val));
            cur1 = cur1.next;
        }

        Node cur2 = head;
        while (cur2 != null) {
            map.get(cur2).next = map.get(cur2.next);
            map.get(cur2).random = map.get(cur2.random);
            cur2 = cur2.next;
        }

        return head;
    }
}
