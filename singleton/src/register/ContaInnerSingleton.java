package register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContaInnerSingleton {

    private ContaInnerSingleton() {}

    private static Map<String, ContaInnerSingleton> map = new ConcurrentHashMap<>();

    public static ContaInnerSingleton getInstance(String className) {

        synchronized (map) {
            if (!map.containsKey(className)) {
                ContaInnerSingleton containnerSingleton = new ContaInnerSingleton();
                map.put(className, containnerSingleton);
                return containnerSingleton;
            } else {
                return map.get(className);
            }
        }
    }
}
