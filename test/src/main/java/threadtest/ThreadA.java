package threadtest;

public class ThreadA extends Thread {
    private WaitTest waitTest;

    public ThreadA(WaitTest waitTest) {
        this.waitTest = waitTest;
    }

    @Override
    public void run() {
        synchronized (waitTest) {
            try {
                waitTest.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA end");
        }
    }
}
