package org.sandbox.object.creation;

public final class Person implements Cloneable {
    
    private String name;
    
    private int age;
    
    private Address address;
    
    
    public Person(final String name, final int age, final Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person clone() {
        try {
            Person person = (Person) super.clone();
            person.address = this.address.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    
    public void setAge(final int age) {
        this.age = age;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(final Address address) {
        this.address = address;
    }
    
}
