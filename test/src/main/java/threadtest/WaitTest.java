package threadtest;

public class WaitTest {
    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();

        ThreadA threadA = new ThreadA(waitTest);
//        ThreadB threadB = new ThreadB(waitTest);
        ThreadC threadC = new ThreadC(waitTest);

        threadA.start();
//        threadB.start();

        try {
            threadA.join();
//            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.start();
    }
}
