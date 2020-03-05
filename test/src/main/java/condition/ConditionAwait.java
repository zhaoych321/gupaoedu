package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionAwait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionAwait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("ConditionAwait start!");
            condition.await();
            System.out.println("ConditionAwait end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionSingle(lock, condition)).start();
        new Thread(new ConditionAwait(lock, condition)).start();
    }
}
