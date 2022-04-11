package org.sandbox.patterns.state;

import org.sandbox.patterns.state.machine.VendingMachine;

public final class VendingMachineCustomerMain {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(1);
        
        vendingMachine.selectProduct();
        vendingMachine.cancelRequest();
        System.out.println("------------------------");
        
        vendingMachine.insertCoin();
        vendingMachine.cancelRequest();
        System.out.println("------------------------");
        
        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        System.out.println("------------------------");
        
        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.cancelRequest();
    }

}
