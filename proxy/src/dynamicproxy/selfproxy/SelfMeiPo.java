package dynamicproxy.selfproxy;

import java.lang.reflect.Method;

public class SelfMeiPo implements SelfInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return SelfProxy.newProxyInstance(new SelfClassLoader(), clazz.getInterfaces(), this);
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

