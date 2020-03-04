package org.example.jdk;

import org.example.Person;

/**
 * Created by Tom on 2019/3/10.
 */
public class Girl implements Person {
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
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
