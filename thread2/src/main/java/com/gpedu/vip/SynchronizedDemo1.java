package com.gpedu.vip;

import java.io.IOException;

public class SynchronizedDemo1 {
    static Integer count=0;
    public static void incr(){
        synchronized (count) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("count class = " + count.getClass().);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo1.incr()).start();
        }
        Thread.sleep(10000);
        System.out.println("result:"+count);
    }
}
