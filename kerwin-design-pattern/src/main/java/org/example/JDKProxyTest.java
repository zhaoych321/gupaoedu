package org.example;

public class JDKProxyTest {
    public static void main(String[] args) {

        try {
            Person obj = (Person)new GPMeipo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();

            obj.buy(100);

            obj.sell(100.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
