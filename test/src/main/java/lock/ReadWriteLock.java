package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    static Lock readLock = new ReentrantReadWriteLock().readLock();
    public static void main(String[] args) {
        readLock.lock();
    }
}
