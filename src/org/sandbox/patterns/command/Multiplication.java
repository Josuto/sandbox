package org.sandbox.patterns.command;

public final class Multiplication implements OperationReceiver {

    private final int stored;
    
    
    public Multiplication(final int number) {
        this.stored = number;
    }

    @Override
    public int action(final int number) {
        return number * this.stored;
    }

}
