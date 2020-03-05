package threadtest;

import java.util.HashMap;
import java.util.Map;

public class AccountingSync implements Runnable {
//    static AccountingSync instance = new AccountingSync();
//
//    //共享资源（临界资源）
//    static int i = 0;
//
//    public synchronized void increase() {
//        i ++;
//    }
//
//    public void run() {
//        synchronized (instance) {
//            for (int j = 0; j < 1000; j++) {
//                increase();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        AccountingSync accountingSync = new AccountingSync();
//        Thread thread1 = new Thread(accountingSync);
//        Thread thread2 = new Thread(accountingSync);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println("=========================" + i);
//    }
    static AccountingSync instance=new AccountingSync();
    static int i=0;
    static int j=0;
    @Override
    public void run() {
        for(int j=0;j<1000;j++){

            //this,当前实例对象锁
            synchronized(AccountingSync.class) {
                i++;
                System.out.println("threadName: " + Thread.currentThread().getName() + " , i = " + i);
                increase();//synchronized的可重入性
            }
        }
    }

    public synchronized void addI(){
        i++;
        System.out.println("threadName: " + Thread.currentThread().getName() + " , i = " + i);
        increase();//synchronized的可重入性
    }

    public synchronized void increase(){
        i++;
    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread t1=new Thread(instance);
//        Thread t2=new Thread(instance);
//        t1.start();t2.start();
//        t1.join();t2.join();
//        System.out.println(i);
//    }

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(1, 1);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            entry.setValue(entry.getValue() / 10);
        }
        System.out.println(hashMap);
    }
}
