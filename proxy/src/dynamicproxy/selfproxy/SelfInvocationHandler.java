package dynamicproxy.selfproxy;

import java.lang.reflect.Method;

public interface SelfInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
