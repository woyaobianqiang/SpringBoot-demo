package com.example.leetcode.demos.web;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Test {

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task, "1");
        Thread t2 = new Thread(task, "2");
        t1.start();
        t2.start();
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();

    }

    public static void fizzBuzz(int n) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}

class Task implements Runnable {
    int i = 0;

    @Override
    public synchronized void run() {

        while (i < 100) {
            i++;
            System.out.println(Thread.currentThread().getName() + "  " + i);
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        new Thread().interrupt();
    }
}