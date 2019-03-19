package threadlocal;

public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return super.initialValue();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return threadLocal.get();
    }
}
