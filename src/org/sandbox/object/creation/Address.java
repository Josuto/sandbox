package org.sandbox.object.creation;

public final class Address implements Cloneable {

    private String street;
    
    private int number;
    
    
    public Address(final String street, final int number) {
        this.street = street;
        this.number = number;
    }

    public Address clone() {
        try {
            return (Address) super.clone();
        }
        catch (CloneNotSupportedException exception) {
            throw new AssertionError(); // Can't happen
        }
    }
    
    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }
    
}
