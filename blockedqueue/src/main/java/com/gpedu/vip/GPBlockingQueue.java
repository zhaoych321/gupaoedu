package com.gpedu.vip;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GPBlockingQueue<E> {

    private ArrayList<E> tasks;
    private int maxSize = 5;

    private ReentrantLock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public GPBlockingQueue() {
        this.tasks = new ArrayList<>();
    }

    public GPBlockingQueue(ArrayList<E> tasks, int maxSize) {
        this.tasks = tasks;
        this.maxSize = maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(E v) {
        try {
            lock.lock();

            while (tasks.size() >= maxSize) {
                System.out.println("队列已经满了！！！");
                notFull.await();
            }

            tasks.add(v);
            System.out.println("队列添加元素 v = " + v + " , size = " + tasks.size());

            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E task() {
        E v = null;
        try {
            lock.lock();

            while (tasks.isEmpty()) {
                System.out.println("队列是空队列！！！");
                notEmpty.await();
            }

            v = tasks.remove(0);
            System.out.println("队列取出元素 v = " + v + " , size = " + tasks.size());

            notFull.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return v;
    }
}
