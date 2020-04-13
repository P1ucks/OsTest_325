package com.company;

public class Monitor {
    int number;
    Buffer buffer;
    Method method;
    public Monitor(Buffer buffer, Method method, int number) {
        this.buffer = buffer;
        this.method = method;
        this.number = number;
    }
    public void put(){
        if(buffer.notFull()) {
            method.p();
            buffer.putItem();
            System.out.println(number + " 号生产者生产一件 " + buffer);
            method.v();
        }
    }
    public void get(){
        if(buffer.notEmpty()) {
            method.p();
            buffer.getItem();
            System.out.println(number + " 号消费者消费一件 " +buffer);
            method.v();
        }
    }
}
