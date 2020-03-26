package org.example;

public abstract class OperatorInterpreter implements IInterpreter {
    IInterpreter left;
    IInterpreter right;

    public OperatorInterpreter(IInterpreter left, IInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
