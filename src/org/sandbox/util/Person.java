package org.sandbox.util;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a person.
 * <p>
 * {@link Person}s must be mutually comparable. Thus, this class implements
 * {@link Comparable}. This implementation provides natural ordering during
 * sorting operations of collections of people. To ensure natural ordering
 * {@link #compareTo(Person)} must be consistent with {@link #equals(Object)}.
 * 
 * @author josumartinez
 *
 */
public class Person implements Comparable<Person> {
    
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    
    
    public Person(final String firstName, final String lastName, final LocalDate birthday) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(birthday);
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    @Override
    public int hashCode() {
        int hashCode = firstName.hashCode();
        hashCode = 31 * hashCode + lastName.hashCode();
        hashCode = 31 * hashCode + birthday.hashCode();
        return hashCode;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        else {
            Person person = (Person) object;
            return lastName.equals(person.lastName) 
                    && firstName.equals(person.firstName)
                    && birthday.equals(person.birthday);
        }
    }
    
    @Override
    public int compareTo(Person person) {
        int lastNameComp = lastName.compareTo(person.lastName);
        int firstNameComp = firstName.compareTo(person.firstName);
        
        return lastNameComp != 0 ? lastNameComp 
                : firstNameComp != 0 ? firstNameComp : birthday.compareTo(person.birthday);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
