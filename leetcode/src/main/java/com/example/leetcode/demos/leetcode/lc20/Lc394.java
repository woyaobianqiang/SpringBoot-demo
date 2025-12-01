package com.example.leetcode.demos.leetcode.lc20;

import java.util.Stack;

public class Lc394 {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                resStack.push(res);
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                Integer repeatTimes = numStack.pop();
                StringBuilder lastRes = resStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (Integer i = 0; i < repeatTimes; i++) {
                    tmp.append(res);
                }
                res = lastRes.append(tmp);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
