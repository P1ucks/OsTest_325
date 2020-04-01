package com.company;

public class Main {
    public static void main(String[] args) {
        // 缓冲区大小为 10
        Buffer buffer = new Buffer(10);
        // 设置整数型信号量大小
        Method mutex = new Semaphore(1);
        // 创建 5 个生产者和 5 个消费者
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(buffer,mutex)).start();
            new Thread(new Consumer(buffer,mutex)).start();
        }
    }
}

