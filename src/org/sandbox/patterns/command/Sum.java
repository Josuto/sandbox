package org.sandbox.patterns.command;

public final class Sum implements OperationReceiver {
    
    private final int stored;
    
    
    public Sum(final int number) {
        this.stored = number;
    }

    @Override
    public int action(final int number) {
        return number + this.stored;
    }

}
