package org.example.thread;

public class Test {
    public static void main(String[] args) {
        Thread threadB = new ThreadB();
        new ThreadA(threadB).start();
        threadB.start();
    }
}
