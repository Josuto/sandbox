package org.sandbox.patterns.state.machine;

public final class AllProductsSoldOutState implements State {

    @SuppressWarnings("unused")
    private final VendingMachine vendingMachine;
    
    
    public AllProductsSoldOutState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("You cannot insert any coin now; all products are sold out");
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
