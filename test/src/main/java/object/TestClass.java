package object;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class c1 = String.class;
        for (Method m : c1.getDeclaredMethods()) {
            System.out.println("c1 method = " + m);
        }
        AnnotatedType[] annotatedInterfaces = c1.getAnnotatedInterfaces();
        for (AnnotatedType a : annotatedInterfaces) {
            System.out.println("AnnotatedType = " + a);
        }

        Class p1 = person.getClass();
        for (Method m : p1.getDeclaredMethods()) {
            System.out.println("p1 method = " + m);
        }
        Class strClass = Class.forName("java.lang.String");
        System.out.println("c1 = " + c1 + " , p1 = " + p1 + " , strClass = " + strClass);
}
}
