package dynamicproxy.selfproxy;

import dynamicproxy.jdkproxy.Girl;
import staticproxy.*;

public class SelfProxyTest {
    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new SelfMeiPo().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
