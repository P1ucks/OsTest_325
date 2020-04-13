package com.company;

//消费者实体类
public class Consumer implements Runnable {
    //统计消费者数量
    private static int total = 0;
    //消费者个体的 id
    private int id;
    //传入缓冲区地址，同步机制
    public Consumer(Buffer buffer,Method method) {
        this.id = ++total;
        this.monitor = new Monitor(buffer,method,id);
    }
    //管程
    private Monitor monitor;
    //打印消费者信息
    @Override
    public String toString() {
        return id + " 号消费者";
    }
    @Override
    public void run() {
        while (true) {
            monitor.get();
            //睡眠
            try{
                int sleep = (int)(Math.random()*1000);
                Thread.sleep(sleep);
            }catch (Exception e){

            }
        }
    }
}
