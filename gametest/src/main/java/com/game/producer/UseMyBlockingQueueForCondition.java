package com.game.producer;

public class UseMyBlockingQueueForCondition {
    public static void main(String[] args) {
        MyBlockingQueueForCondition queue = new MyBlockingQueueForCondition(10);

        Runnable producer = ()->{
            while(true) {
                try {
                    Object o = new Object();
                    queue.put(o);
                    System.out.println("线程"+Thread.currentThread().getName()+"放入对象：" + o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = ()->{
            while (true) {
                try {
                    Object o = queue.take();
                    System.out.println("线程"+Thread.currentThread().getName()+"取出对象：" + o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
