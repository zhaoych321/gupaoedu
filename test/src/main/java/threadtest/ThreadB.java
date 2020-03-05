package threadtest;

public class ThreadB extends Thread {
    private WaitTest waitTest;

    public ThreadB(WaitTest waitTest) {
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
            System.out.println("ThreadB end");
        }
    }
}
