package org.example;

public class AddOpteratorInterpreter extends OperatorInterpreter {
    public AddOpteratorInterpreter(IInterpreter left, IInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() + right.interpreter();
    }
}
