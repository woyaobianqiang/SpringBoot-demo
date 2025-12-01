package com.example.leetcode.demos.leetcode.lc200;

import java.util.HashMap;
import java.util.Map;

public class Lc208 {

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node());
                }
                cur = cur.child.get(c);
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    return false;
                }
                cur = cur.child.get(c);
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    return false;
                }
                cur = cur.child.get(c);
            }
            return true;
        }

        class Node {
            boolean isEnd;
            Map<Character, Node> child;

            Node() {
                isEnd = false;
                child = new HashMap<>();
            }
        }
    }
}
