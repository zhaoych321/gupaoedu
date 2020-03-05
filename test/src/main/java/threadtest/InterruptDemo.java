package threadtest;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

//    private static int i = 0;
//
//    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.currentThread().isInterrupted()) i++;
//
//                System.out.println("i = " + i);
//            }
//        }, "InterruptDemo");
//
//        thread.start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread.interrupt();
//    }

    private static int i;
    public static void
    main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对线程进行复位，由 true 变成 false
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        },"interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}