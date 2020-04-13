package com.company;
//buffer
public class Buffer {
    //当前产品数量
    private int count = 0;
    //最大允许数量
    private int max;
    public int getMax() {
        return max;
    }
    public Buffer(int max) {
        this.max = max;
    }
    //判断缓冲区是否为满
    public boolean notFull() {
        return (count < max);
    }
    //判断缓冲区是否为空
    public boolean notEmpty() {
        return (count > 0);
    }
    //生产产品
    public void putItem() {
        count++;
    }
    //消费产品
    public void getItem() {
        count--;
    }
    //打印缓冲区信息
    @Override
    public String toString() {
        return "缓冲区内有 " + count + " 件产品";
    }
}
