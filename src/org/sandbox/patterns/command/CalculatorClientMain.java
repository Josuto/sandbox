package org.sandbox.patterns.command;

public final class CalculatorClientMain {

    public static void main(String[] args) {
        CalculatorInvoker calculator = new CalculatorInvoker();
        OperationReceiver add = new Sum(2);
        OperationReceiver multiply = new Multiplication(3);
        OperationReceiver divide = new Division(2);
        OperationReceiver substract = new Substraction(3);
        
        calculator.pushCommand(add::action);
        calculator.pushCommand(multiply::action); // ~ (x) -> { return multiply.action(x); }
        calculator.pushCommand(divide::action);
        calculator.pushCommand(substract::action);
        
        int result = calculator.evaluate();
        System.out.println("The result of the operation evaluation is: " + result); // should be 0
    }

}
