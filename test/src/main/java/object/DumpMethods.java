package object;

import java.lang.reflect.Method;

public class DumpMethods {
    public static void main(String[] args) throws ClassNotFoundException {
        final Class<?> aClass = Class.forName("java.util.Stack");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i ++) {
            System.out.println(declaredMethods[i].toString());
        }
    }
}
