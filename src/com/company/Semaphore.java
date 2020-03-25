package com.company;

public class Semaphore implements Method{
    private int semValue;
    public Semaphore(int semValue){
        this.semValue = semValue;
    }
    public synchronized void p(){
        semValue--;
        if(semValue<0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void v(){
        semValue++;
        if(semValue<=0){
            this.notify();
        }
    }
}
