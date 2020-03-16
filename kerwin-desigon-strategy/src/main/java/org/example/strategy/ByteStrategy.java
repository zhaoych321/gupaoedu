package org.example.strategy;

public class ByteStrategy implements  IStrategy {
    @Override
    public void tranfer(String context) {
        System.out.println("使用二进制转数据！");
    }
}
