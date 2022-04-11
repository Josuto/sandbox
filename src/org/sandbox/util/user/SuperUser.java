package org.sandbox.util.user;

import java.time.LocalDate;

public class SuperUser extends NormalUser {

    private final String password;
    
    
    public SuperUser(
            final String firstName,
            final String lastName,
            final LocalDate birthday, 
            final String username,
            final String password) {
        super(firstName, lastName, birthday, username);
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
}
