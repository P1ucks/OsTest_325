package com.company;

//消费者实体类
public class Consumer implements Runnable {
    //统计消费者数量
    private static int total = 0;
    //消费者个体的 id
    private int id;
    //模拟缓冲区
    private Buffer buffer;
    //允许动态更改同步机制
    private Method method;
    //传入缓冲区地址，同步机制
    public Consumer(Buffer buffer,Method method) {
        this.id = ++total;
        this.buffer = buffer;
        this.method = method;
    }
    //打印消费者信息
    @Override
    public String toString() {
        return id + " 号消费者";
    }
    @Override
    public void run() {
        while (true) {
            //p操作
           method.p();
            // 临界区代码
            if (buffer.notEmpty()) {
                // 消费产品
                buffer.getItem();
                System.out.println(this  + " 取走一件产品： " + buffer);
            }
            //v操作
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
