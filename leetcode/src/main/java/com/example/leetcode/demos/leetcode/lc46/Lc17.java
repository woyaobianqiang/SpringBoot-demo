package com.example.leetcode.demos.leetcode.lc46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17 {
    List<String> res = new ArrayList<>();
    static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    public void dfs(String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
        }

        char c = digits.charAt(index);
        String letters = map.get(c);
        if (letters == null) {
            dfs(digits, sb, index + 1);
            return;
        }

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));

            dfs(digits, sb, index + 1);

            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
