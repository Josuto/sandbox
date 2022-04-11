package org.sandbox.patterns.state.machine;

public final class RestState implements State {

    private final VendingMachine vendingMachine;
    
    
    public RestState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("A coin has been inserted");
        this.vendingMachine.setState(new CoinInsertedState(this.vendingMachine));
    }

    @Override
    public void cancelRequest() {
        System.out.println("There is no request to cancel");
    }

    @Override
    public void selectProduct() {
        System.out.println("First insert a coin before selecting a product");
    }

    @Override
    public void dispenseProduct() {
        // TODO Throw UnsupportedOperationExceptions instead
        System.out.println("Cannot dispense a product now");
    }

}
