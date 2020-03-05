package threadtest;

import java.util.concurrent.TimeUnit;

public class InterruptDemo2 {
    private static
    int i;
    public static
    void main(String[] args) throws InterruptedException
    {
        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Num:"+i);
        },"interruptDemo");
                thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
