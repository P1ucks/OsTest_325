package com.company;

//生产者实体类
public class Producer implements Runnable {
    //统计生产者数量
    private static int total = 0;
    //生产者个体的 id
    private int id;
    //传入缓冲区地址，同步机制
    public Producer(Buffer buffer,Method method) {
        this.id = ++total;
        this.monitor = new Monitor(buffer,method,id);
    }
    private Monitor monitor;
    //打印生产者信息
    @Override
    public String toString() {
        return id + " 号生产者";
    }
    @Override
    public void run() {
        while (true) {
            monitor.put();
            //睡眠
            try{
                int sleep = (int)(Math.random()*1000);
                Thread.sleep(sleep);
            }catch (Exception e){

            }
        }
    }
}
