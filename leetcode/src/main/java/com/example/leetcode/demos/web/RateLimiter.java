package com.example.leetcode.demos.web;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    int windowSize;
    int times;
    int limitWindows;
    Map<Long, Integer> map;
    long curLimitTimeStamp;

    public RateLimiter(int times, int limitWindows) {
        this.times = times;
        this.limitWindows = limitWindows;
        map = new HashMap<>();
    }

    // 60秒内超过2次，禁止2秒
    public boolean isValid() {
        long now = System.currentTimeMillis();
        long minute = now / 1000 / 60;
        // 当前窗口的请求数
        int window = map.getOrDefault(minute, 0);
        window++;

        // 禁止两秒
        if (now < curLimitTimeStamp) {
            return false;
        }

        // 限流
        if (window > times) {
            // 记录下次放行时间
            curLimitTimeStamp = now + limitWindows;
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(2, 2000);
        for (int i = 0; i < 10; i++) {
            boolean valid = rateLimiter.isValid();
            System.out.println(valid);
        }
    }
}


