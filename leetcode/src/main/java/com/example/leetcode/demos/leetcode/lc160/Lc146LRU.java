package com.example.leetcode.demos.leetcode.lc160;

import java.util.HashMap;
import java.util.Map;

public class Lc146LRU {

    class LRUCache {
        private Node head;
        private Node tail;
        private Map<Integer, Node> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }

        public void insertToHead(Node node) {
            Node first = head.next;
            node.next = first;
            first.prev = node;
            first.next = node;
            node.prev = first;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public void moveToHead(Node node) {
            remove(node);
            insertToHead(node);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                insertToHead(newNode);
                if (map.size() > capacity) {
                    Node node = removeTail();
                    map.remove(node.key);
                }
            }
        }

        class Node {
            private Node prev;
            private Node next;
            private int key;
            private int val;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

}
