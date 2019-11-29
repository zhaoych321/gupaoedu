package com.game.producer;

import java.util.LinkedList;

public class MyBlockingQueue {

    private int maxSize;
    private LinkedList storage;

    public MyBlockingQueue(int size) {
        this.maxSize = size;
        storage = new LinkedList();
    }

    public synchronized void put() throws InterruptedException {
        while (storage.size() == maxSize) {
            wait();
        }
        Object o = new Object();
        storage.add(o);
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        Object o = storage.remove();
        notifyAll();
        return o;
    }

}
