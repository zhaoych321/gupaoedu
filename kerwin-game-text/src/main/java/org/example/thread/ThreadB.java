package org.example.thread;

public class ThreadB extends Thread {

    @Override
    public void run() {
        System.out.println("线程B执行！start");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程B执行！end");
    }
}
