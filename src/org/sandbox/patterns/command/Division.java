package org.sandbox.patterns.command;

public final class Division implements OperationReceiver {

    private final int stored;
    
    
    public Division(final int number) {
        this.stored = number;
    }

    @Override
    public int action(final int number) {
        return number / this.stored;
    }

}
