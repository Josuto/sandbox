package org.sandbox.patterns.state.machine;

public class CoinInsertedState implements State {

    private final VendingMachine vendingMachine;
    
    
    public CoinInsertedState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("A coin has been inserted");
    }

    @Override
    public void cancelRequest() {
        System.out.println("Request canceled. Ejecting the inserted coins");
        this.vendingMachine.setState(new RestState(this.vendingMachine));
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected");
        this.vendingMachine.setState(new ProductSoldState(this.vendingMachine));
    }

    @Override
    public void dispenseProduct() {
        // TODO Throw UnsupportedOperationExceptions instead
        System.out.println("Cannot dispense a product now");
    }

}
