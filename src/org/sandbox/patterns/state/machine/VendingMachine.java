package org.sandbox.patterns.state.machine;

/**
 * This class emulates a vending machine implementing the State design pattern.
 * 
 * @implNote Currently, any instance of this class can only dispense a type of
 *           product that can be bought with a single coin.
 * 
 * @author josumartinez
 *
 */
public final class VendingMachine {

    private State currentState = new RestState(this);
    
    private int availableProductUnits;
    
    
    public VendingMachine(final int availableProductUnits) {
        this.availableProductUnits = availableProductUnits;
    }
    
    boolean isEmpty() {
        return this.availableProductUnits == 0;
    }
    
    void reduceAvailableProductUnits() {
        this.availableProductUnits--;
    }

    public void insertCoin() {
        this.currentState.insertCoin();
    }
    
    public void cancelRequest() {
        this.currentState.cancelRequest();
    }
    
    public void selectProduct() {
        this.currentState.selectProduct();
        this.currentState.dispenseProduct();
    }
    
    public void setState(final State state) {
        this.currentState = state;
    }
    
}
