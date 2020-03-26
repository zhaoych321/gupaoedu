package org.example;

public class NumberInterpreter implements IInterpreter {

    int value;

    public NumberInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpreter() {
        return this.value;
    }
}
