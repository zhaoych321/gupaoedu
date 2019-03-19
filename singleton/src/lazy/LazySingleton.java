package lazy;

public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {}

    public synchronized  static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
