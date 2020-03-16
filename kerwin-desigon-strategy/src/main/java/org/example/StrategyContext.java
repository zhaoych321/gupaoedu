package org.example;

import org.example.strategy.ByteStrategy;
import org.example.strategy.IStrategy;
import org.example.strategy.ProtocolStrategy;
import org.example.strategy.ThriftStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyContext {
    private static Map<TranferType, IStrategy> strategys = new HashMap<>();

    static {
        strategys.put(TranferType.byte2, new ByteStrategy());
        strategys.put(TranferType.thrift, new ThriftStrategy());
        strategys.put(TranferType.protocol, new ProtocolStrategy());
    }

    public static IStrategy get(TranferType type) {
        final IStrategy strategy = strategys.get(type);
        return strategy == null ? strategys.get(TranferType.byte2) : strategy;
    }

    enum TranferType{
        byte2, protocol, thrift
    }
}
