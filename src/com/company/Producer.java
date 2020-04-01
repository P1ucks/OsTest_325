package com.company;

//生产者实体类
public class Producer implements Runnable {
    //统计生产者数量
    private static int total = 0;
    //生产者个体的 id
    private int id;
    //模拟缓冲区
    private Buffer buffer;
    //允许动态更改同步机制
    private Method method;
    //传入缓冲区地址，同步机制
    public Producer(Buffer buffer,Method method) {
        this.id = ++total;
        this.buffer = buffer;
        this.method = method;
    }
    //打印生产者信息
    @Override
    public String toString() {
        return id + " 号生产者";
    }
    @Override
    public void run() {
        while (true) {

            //Test-and-Set
            method.p();
            // 临界区代码
            if (buffer.notFull()) {
                // 生产产品
                buffer.putItem();
                System.out.println(this  + " 生产一件产品: " + buffer);
            }
            //退出区
            method.v();
            //睡眠
            try{
                int sleep = (int)(Math.random()*1000);
                Thread.sleep(sleep);
            }catch (Exception e){

            }
        }
    }
}
