package org.sandbox.generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.sandbox.util.user.NormalUser;
import org.sandbox.util.user.SuperUser;
import org.sandbox.util.user.User;

public final class UserManagement {

    private static class UserService {
        
        private static <T extends User> int countByType(
                final List<? extends User> users, 
                final Class<T> userType) {
            int count = 0;
            for (User user : users) {
                if (userType.isInstance(user))
//                if (userType.isAssignableFrom(user.getClass())) // Same result as isInstance, but more verbose
                    count++;
            }
            return count;
        }
        
    }
    
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new NormalUser("John", "Smith", LocalDate.of(1979, 5, 13), "john.smith"),
                new SuperUser("Peter", "Brooks", LocalDate.of(1985, 12, 6), "peter.brooks", "12345"));
        
        System.out.println("# of users = " + UserService.countByType(users, User.class));
        System.out.println("# of normal users = " + UserService.countByType(users, NormalUser.class));
        System.out.println("# of super users = " + UserService.countByType(users, SuperUser.class));
    }

}
