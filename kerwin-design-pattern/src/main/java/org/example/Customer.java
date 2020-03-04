package org.example;



public class Customer implements Person {

    @Override
    public void findLove(){
        System.out.println("儿子要求：肤白貌美大长腿");
    }

    @Override
    public void buy(int a) {
        System.out.println("打算"+a+"个苹果！");
    }

    @Override
    public int sell(double a) {
        System.out.println("卖"+a+"个梨！");
        return 100;
    }
}
