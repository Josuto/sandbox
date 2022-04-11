package org.sandbox.util.user;

import java.time.LocalDate;

public interface User {
    
    public String getName();
    
    public LocalDate getBirthday();
    
    public default int compareByName(final User user) {
        return this.getName().compareTo(user.getName());
    }
    
    public static int compareByAge(final User user1, final User user2) {
        return user1.getBirthday().compareTo(user2.getBirthday());
    }
    
}
