package org.example;

public class DivOpteratorInterpreter extends OperatorInterpreter {
    public DivOpteratorInterpreter(IInterpreter left, IInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() / right.interpreter();
    }
}
