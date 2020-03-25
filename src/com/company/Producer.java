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
   // private Method method;
    //传入缓冲区地址，同步机制
    public Producer(Buffer buffer) {
        this.id = ++total;
        this.buffer = buffer;
       // this.method = method;
    }
    //打印生产者信息
    @Override
    public String toString() {
        return id + " 号生产者";
    }
    @Override
    public void run() {
        while (true) {
            TsUtil t = new TsUtil();
            //Test-and-Set
            while(t.TS(lock.now));
            // 临界区代码
            if (buffer.notFull()) {
                // 生产产品
                buffer.putItem();
                System.out.println(this  + " 生产一件产品: " + buffer);
            }
            //退出区
            lock.now = false;
            //睡眠
            try{
                int sleep = (int)(Math.random()*1000);
                Thread.sleep(sleep);
            }catch (Exception e){

            }
        }
    }
}
