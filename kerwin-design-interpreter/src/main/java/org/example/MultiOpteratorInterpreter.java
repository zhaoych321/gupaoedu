package org.example;

public class MultiOpteratorInterpreter extends OperatorInterpreter {
    public MultiOpteratorInterpreter(IInterpreter left, IInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() * right.interpreter();
    }
}
