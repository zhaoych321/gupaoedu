package org.example;

import java.util.Stack;

public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    public static OperatorInterpreter getInterpreter(Stack<IInterpreter> numStack, Stack<String> operatorStack) {
        IInterpreter rightExpr = numStack.pop();
        IInterpreter leftExpr = numStack.pop();
        String symbol = operatorStack.pop();
        System.out.println("数字出栈："+rightExpr.interpreter()+","+leftExpr.interpreter()+",操作符出栈:"+symbol);
        if (symbol.equals("+")) {
            return new AddOpteratorInterpreter(leftExpr, rightExpr);
        } else if (symbol.equals("-")) {
            return new SubOpteratorInterpreter(leftExpr, rightExpr);
        } else if (symbol.equals("*")) {
            return new MultiOpteratorInterpreter(leftExpr, rightExpr);
        } else if (symbol.equals("/")) {
            return new DivOpteratorInterpreter(leftExpr, rightExpr);
        }
        return null;
    }
}
