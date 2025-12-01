package com.example.leetcode.demos.leetcode.lc160;

import java.util.HashMap;
import java.util.Map;

public class Lc146TtlLRU {

    class LRUCache {
        Node head;
        Node tail;
        Map<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node(0, 0, -1);
            tail = new Node(0, 0, -1);
            head.next  = tail;
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

        // removeToHead
        public void removeToHead(Node node) {
            remove(node);
            insertToHead(node);
        }

        // removeTail
        public Node removeTail() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public void eviction() {
            while (tail.prev != head) {
                Node last = tail.prev;
                if (last.isExpired()) {
                    remove(last);
                    map.remove(last.key);
                } else {
                    break;
                }
            }

            while (map.size() > capacity) {
                Node node = removeTail();
                map.remove(node.key);
            }
        }

        public synchronized int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            // 是否过期
            Node node = map.get(key);
            if (node.isExpired()) {
                remove(node);
                map.remove(node.key);
                return -1;
            }

            removeToHead(node);
            return node.val;
        }

        public synchronized void put(int key, int value, long ttl) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                node.expireTime = System.currentTimeMillis() + ttl;
                removeToHead(node);
            } else {
                Node newNode = new Node(key, value, ttl);
                map.put(key, newNode);
                insertToHead(newNode);
            }

            eviction();
        }

        class Node {
            Node prev;
            Node next;
            int key;
            int val;
            long expireTime;

            public Node(int key, int val, long ttl) {
                this.key = key;
                this.val = val;
                if (ttl > 0) {
                    this.expireTime = System.currentTimeMillis() + ttl;
                } else {
                    this.expireTime = Long.MAX_VALUE;
                }
            }

            public boolean isExpired() {
                return System.currentTimeMillis() > expireTime;
            }
        }
    }
}
