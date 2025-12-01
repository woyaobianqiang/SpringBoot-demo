package com.example.leetcode.demos.web;

import java.util.HashMap;
import java.util.Map;

public class Lc1126 {

    class LRUCache {
        int capacity;
        Map<Integer, Node> map;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity * 2);
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // insertToHead
        public void insertToHead(Node node) {
            Node first = head.next;
            node.next = first;
            first.prev = node;
            head.next = node;
            node.prev = head;
        }

        // remove
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // removeTail
        public Node removeTail() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // removeToHead
        public void removeToHead(Node node) {
            remove(node);
            insertToHead(node);
        }

        // get
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            removeToHead(node);
            return node.val;
        }

        // put
        public void put(int key, int val) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = val;
                removeToHead(node);
            } else {
                Node newNode = new Node(key, val);
                map.put(key, newNode);
                removeToHead(newNode);
                if (map.size() > capacity) {
                    Node last = removeTail();
                    map.remove(last.key);
                }
            }
        }

        class Node {
            Node prev;
            Node next;
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }



}
