package org.example;

public class SubOpteratorInterpreter extends OperatorInterpreter {
    public SubOpteratorInterpreter(IInterpreter left, IInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() - right.interpreter();
    }
}
