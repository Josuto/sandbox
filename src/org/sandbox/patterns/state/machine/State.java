package org.sandbox.patterns.state.machine;

public interface State {

    public void insertCoin();

    public void cancelRequest();
    
    public void selectProduct();
    
    public void dispenseProduct();
    
}
