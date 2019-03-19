package hungry;

import java.io.Serializable;

public class HungrySingleton implements Serializable {

    private HungrySingleton() {}

    private static final HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    public Object readResolve() {
        return instance;
    }
}
