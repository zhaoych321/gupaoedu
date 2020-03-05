package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionSingle implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionSingle(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("ConditionSingle start!");
            condition.signal();
            System.out.println("ConditionSingle end!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
