package dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeipoJdkProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(this.target, args);
        after();
        return o;
    }

    private void before() {
        System.out.println("代理前处理！");
    }

    private void after() {
        System.out.println("代理后处理！");
    }
}
