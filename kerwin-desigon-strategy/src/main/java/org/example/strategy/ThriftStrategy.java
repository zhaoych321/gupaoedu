package org.example.strategy;

public class ThriftStrategy implements IStrategy {
    @Override
    public void tranfer(String context) {
        System.out.println("使用Thrift转数据！");
    }
}
