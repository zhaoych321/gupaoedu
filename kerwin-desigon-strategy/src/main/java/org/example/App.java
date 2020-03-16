package org.example;

import org.example.strategy.IStrategy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        IStrategy strategy = StrategyContext.get(StrategyContext.TranferType.byte2);
        strategy.tranfer("");
        strategy = StrategyContext.get(StrategyContext.TranferType.protocol);
        strategy.tranfer("");
        strategy = StrategyContext.get(StrategyContext.TranferType.thrift);
        strategy.tranfer("");
    }
}
