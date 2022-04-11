package org.sandbox.patterns.state.machine;

public final class ProductSoldState implements State {

    private final VendingMachine vendingMachine;
    
    
    public ProductSoldState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("You cannot insert any coin now");
    }

    @Override
    public void cancelRequest() {
        System.out.println("You cannot cancel the request now");
    }

    @Override
    public void selectProduct() {
        System.out.println("You cannot select any product now");
    }

    @Override
    public void dispenseProduct() {
        this.vendingMachine.reduceAvailableProductUnits();
        System.out.println("Product dispensed");
        if (this.vendingMachine.isEmpty()) {
            this.vendingMachine.setState(new AllProductsSoldOutState(this.vendingMachine));
        }
        else {
            this.vendingMachine.setState(new RestState(this.vendingMachine));
        }
    }

}
