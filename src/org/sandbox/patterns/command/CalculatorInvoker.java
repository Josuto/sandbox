package org.sandbox.patterns.command;

import org.sandbox.collection.queue.ArrayQueue;
import org.sandbox.collection.queue.Queue;

public final class CalculatorInvoker {

    private Queue<Command> commands;
    
    
    public CalculatorInvoker() {
        this.commands = new ArrayQueue<>(); // accept max 10 commands
    }
    
    public void pushCommand(final Command command) {
        this.commands.enqueue(command);
    }
    
    public int evaluate() {
        int result = 0;
        while (!this.commands.isEmpty()) {
            Command command = this.commands.dequeue().orElseThrow();
            result = command.execute(result);
        }
        return result;
    }
    
}
