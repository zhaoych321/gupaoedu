package com.gpedu.vip;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        GPBlockingQueue<Object> objectGPBlockingQueue = new GPBlockingQueue<>();
        for (int i = 0; i < 100; ++i) {
            new PutTask(objectGPBlockingQueue, i).start();
            new TaskTask(objectGPBlockingQueue).start();
        }
    }

    public static class PutTask extends Thread {

        private GPBlockingQueue queue;
        private int v;

        public PutTask(GPBlockingQueue queue, int v) {
            this.queue = queue;
            this.v = v;
        }

        @Override
        public void run() {
            queue.put(v);
        }
    }

    public static class TaskTask extends Thread {

        private GPBlockingQueue queue;

        public TaskTask(GPBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int v = (int)queue.task();
            System.out.println("取出数据为：" + v);
        }
    }
}
