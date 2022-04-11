package org.sandbox.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.sandbox.util.user.NormalUser;
import org.sandbox.util.user.SuperUser;
import org.sandbox.util.user.User;

/**
 * This class exercises several lambda and method references.
 * <p>
 * All the sort methods included in this class use @{code
 * Collections.sort(List<T> list, Comparator<? super T> c)} to actually perform
 * the sort. The second argument of this method is a functional interface. Thus,
 * when used, {@code Collections.sort} takes a functional object that implements
 * {@code Comparator} as input parameter. Such functional object that may be a
 * lambda expression or a method reference. The compiler infers the function
 * object's actual input parameter types from {@code Comparator<User>.compare}.
 * Finally, the function object's body is the logic expressed by the body of the
 * lambda or the referred method.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public class MethodReferences {

    /**
     * Sorts the given {@link User}s by name (alphabetically) using a lambda
     * expression as function object.
     * 
     * @param src
     * @return
     */
    public static List<User> sortByNameUsingLambda(final List<? extends User> src) {
        List<User> result = new ArrayList<>(src);
        // The function object is a lambda expression
        Collections.sort(result, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        return result;
    }
    
    /**
     * Sorts the given {@link User}s by age using a static reference method as
     * function object.
     * 
     * @param src
     * @return
     */
    public static List<User> sortByAgeUsingStaticReferenceMethod(final List<? extends User> src) {
        List<User> result = new ArrayList<>(src);
        Collections.sort(result, User::compareByAge);
        return result;
    }

    /**
     * Sorts the given {@link User}s by name (alphabetically) using an unbound
     * reference method as function object i.e., a method that references an
     * instance method of the {@link User} type.
     * 
     * @param src
     * @return
     */
    public static List<User> sortByNameUsingUnboundReferenceMethod(final List<? extends User> src) {
        List<User> result = new ArrayList<>(src);
        Collections.sort(result, User::compareByName);
        return result;
    }
    
    /**
     * Sorts the given {@link User}s by name (alphabetically) using a bound
     * reference method as function object i.e., a method that references an
     * instance method of a concrete instance of {@link User} type.
     * 
     * @param src
     * @return
     */
    public static List<User> sortByNameUsingBoundReferenceMethod(final List<? extends User> src) {
        List<User> result = new ArrayList<>(src);
        Collections.sort(result, new UserComparator()::compareByName);
        return result;
    }

    /**
     * Class required to specify a bound method reference.  
     * 
     * @author Josu Martinez
     * @version 1.0
     *
     */
    private static class UserComparator {
        
        private int compareByName(final User u1, final User u2) {
            return u1.compareByName(u2);
        }
        
    }
    
    /**
     * Copies the source {@link User}s into a destination list of {@link User} and
     * sorts the latter by name (alphabetically). This method enables the use of
     * constructor method references.
     * 
     * @param src
     * @param dst
     * @return
     */
    public static List<User> sortByNameUsingConstructorReferenceMethod(
                final List<? extends User> src, 
                final Supplier<List<? super User>> dst) {
        @SuppressWarnings("unchecked")
        // Since dst is a list of Users, result is typesafe
        List<User> result = (List<User>) dst.get();
        // Specialized list loader that respects the implementation type of dst
        for (User u : src)
            result.add(u);
        Collections.sort(result, new UserComparator()::compareByName);
        return result;
    }
    
    /**
     * Private function that takes a list of {@link User}s, sorts them based on some
     * given sort function, and prints the resulting list contents.
     * 
     * @param users
     *            the given list of {@link User}s.
     * @param sort
     *            the given sort function.
     */
    private static void printUsers(
            final List<? extends User> users, 
            final Function<List<? extends User>, List<User>> sort) {
        sort.apply(users).forEach((u) -> System.out.println(u.getName()));
    }
    
    
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new NormalUser("John", "Smith", LocalDate.of(1979, 5, 13), "john.smith"), 
                new SuperUser("Bob", "Marley", LocalDate.of(1985, 12, 6), "bob.marley", "12345"));
        
        System.out.println("Sort by age (oldest to youngest) using a static reference method:");
        printUsers(users, MethodReferences::sortByAgeUsingStaticReferenceMethod);
        System.out.println("Sort by name (alphabetically) using a lambda:");
        printUsers(users, MethodReferences::sortByNameUsingLambda);
        System.out.println("Sort by name (alphabetically) using an unbounded reference method:");
        printUsers(users, MethodReferences::sortByNameUsingUnboundReferenceMethod);
        System.out.println("Sort by name (alphabetically) using a bounded reference method:");
        printUsers(users, MethodReferences::sortByNameUsingBoundReferenceMethod);
        System.out.println("Sort by name (alphabetically) using a constructor reference method:");
        sortByNameUsingConstructorReferenceMethod(users, ArrayList::new)
                .forEach((u) -> System.out.println(u.getName()));
    }

}
