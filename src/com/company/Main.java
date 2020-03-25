package com.company;

public class Main {
    public static void main(String[] args) {
        // 缓冲区大小为 10
        Buffer buffer = new Buffer(10);
        // 允许动态更改同步机制
       // Method mutex = new Semaphore(1);
        // 创建 5 个生产者和 5 个消费者
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(buffer)).start();
            new Thread(new Consumer(buffer)).start();
        }
    }
}

