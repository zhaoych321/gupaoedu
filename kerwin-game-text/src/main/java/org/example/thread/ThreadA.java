package org.example.thread;

public class ThreadA extends Thread {
    private Thread otherThread;

    public ThreadA(Thread otherThread) {
        this.otherThread = otherThread;
    }

    @Override
    public void run() {
        System.out.println("线程A执行！start");
        try {
            otherThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程A执行！end");
    }
}
