package doublecheck;

public class DoubleCheckSingleton {
    private DoubleCheckSingleton() {}

    private static DoubleCheckSingleton instance = null;

    public static DoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
