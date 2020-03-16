package org.example.strategy;

public class ProtocolStrategy implements IStrategy {
    @Override
    public void tranfer(String context) {
        System.out.println("使用ProtocolBuff转数据！");
    }
}
