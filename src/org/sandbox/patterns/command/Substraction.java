package org.sandbox.patterns.command;

public final class Substraction implements OperationReceiver {

    private final int stored;
    
    
    public Substraction(final int number) {
        this.stored = number;
    }

    @Override
    public int action(final int number) {
        return number - this.stored;
    }

}
