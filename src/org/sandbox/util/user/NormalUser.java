package org.sandbox.util.user;

import java.time.LocalDate;

import org.sandbox.util.Person;

public class NormalUser extends Person implements User {

    private final String username;
    
    
    public NormalUser(
            final String firstName,
            final String lastName,
            final LocalDate birthday, 
            final String username) {
        super(firstName, lastName, birthday);
        this.username = username;
    }
    
    @Override
    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }
    
    public String getUsername() {
        return username;
    }
    
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
        hashCode = 31 * hashCode + username.hashCode();
        return hashCode;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NormalUser)) {
            return false;
        }
        else {
            NormalUser user = (NormalUser) object;
            return super.equals(object)
                    && username.equals(user.username);
        }
    }
    
    @Override
    public String toString() {
        return username;
    }
    
}
