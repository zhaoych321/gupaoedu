package threadtest;

public class ThreadC extends Thread {
    private WaitTest waitTest;

    public ThreadC(WaitTest waitTest) {
        this.waitTest = waitTest;
    }

    @Override
    public void run() {
        synchronized (waitTest) {
            waitTest.notify();
            System.out.println("ThreadC end");
        }
    }
}
