package org.example.bytetest;

public class Test {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println("COUNT_BITS = " + COUNT_BITS);

        int RUNNING = -1 << COUNT_BITS;
        System.out.println("RUNNING = " + RUNNING);

        int ctl = RUNNING | 0;
        System.out.println("ctl = " + ctl);

        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println("CAPACITY = " + CAPACITY);
    }
}
