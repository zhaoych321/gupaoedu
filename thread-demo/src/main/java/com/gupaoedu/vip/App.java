package com.gupaoedu.vip;

/**
 * Hello world!
 *
 */
public class App {

    public volatile static boolean stop=false;

    private final int a;

    public App() {
        this.a = 1;
    }

    public static void main( String[] args ) {
        Thread t1=new Thread(()->{
            int i=0;
            while(!stop){ //condition 不满足
                i++;
            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("11111111");
        }
        stop=true; //true
    }
}
