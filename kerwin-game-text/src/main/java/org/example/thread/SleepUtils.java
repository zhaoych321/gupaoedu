package org.example.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second (long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {

        }
    }
}
