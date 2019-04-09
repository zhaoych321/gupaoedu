package dynamicproxy.jdkproxy;

import staticproxy.Person;
import sun.misc.ProxyGenerator;
import java.io.FileOutputStream;
import java.lang.reflect.Method;


public class MeipoProxyTest {
    public static void main(String[] args) {
        try {
            Object meipo = new MeipoJdkProxy().getInstance(new Girl());
            Method findLove = meipo.getClass().getMethod("findLove", null);
            findLove.invoke(meipo);

//            String packAge = MeipoProxyTest.class.getPackage().toString();
//            System.out.println(packAge);
//            File directory = new File(".");
//            System.out.println(directory.getCanonicalFile());

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write(bytes);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
