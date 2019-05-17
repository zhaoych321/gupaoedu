package com.gpedu.vip;

public class SynchronizedDemo implements Runnable {

    public int x = 0;

    public synchronized void m1() {
        x = 1000;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m1 x = " + x);
    }

    public synchronized void m2() {

        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        x = 2000;
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) {
        SynchronizedDemo s1 = new SynchronizedDemo();
        new Thread(()->s1.m1()).start();
        new Thread(()->s1.m2()).start();

        s1.m2();
        System.out.println("Main main x = " + s1.x);
    }
}
