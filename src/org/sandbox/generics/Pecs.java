package org.sandbox.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * The purpose of this class is showing the PECS (Producer Extends, Consumer
 * Super) mnemonic.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public class Pecs {

    /**
     * Sums the given collection producer of {@link Number}s. 
     * 
     * @param list
     * @return
     */
    public static BigDecimal sum(final Collection<? extends Number> list) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Number number : list) {
            sum = sum.add(new BigDecimal(number.toString()));
        }
        return sum;
    }
    
    /**
     * Transfers the elements of {@link Number} subtype from a given producer
     * collection to a given consumer collection.
     * <p>
     * This method only allows transfer among collections that effectively contain
     * numbers: {@code E} is a subtype of {@link Number}, {@code src} is a
     * collection of some subtype of {@code E}, and {@code dst} is a collection of
     * some super-type of {@code E} (including {@link Object}).
     * 
     * @param src
     * @param dst
     * @return
     */
    public static <E extends Number> Collection<E> transfer(
            final Collection<? extends E> src, 
            final Collection<? super E> dst) {
        for (E number : src)
            dst.add(number);
        @SuppressWarnings("unchecked")
        // The cast is correct as dst can only hold numbers
        Collection<E> result = (Collection<E>) dst;
        return result;
    }
    
    
    public static void main(String[] args) {
        Set<Number> numbers = Set.of(1, 2L, 2.3, new BigDecimal("1e3"));
        System.out.println(sum(transfer(numbers, new ArrayList<Object>())));        // The compiler infers E as Number, and Number :> Object
        System.out.println(sum(transfer(numbers, new ArrayList<Number>())));        // The compiler infers E as Number, and Number :> Number
//        System.out.println(sum(transfer(numbers, new ArrayList<Integer>())));     // Does not compile, as the compiler infers E as Number, and Number !:> Integer 
        Set<Integer> intNumbers = Set.of(0, 1, 2, 3);
        System.out.println(sum(transfer(intNumbers, new ArrayList<Object>())));     // The compiler infers E as Integer, and Integer :> Object
        System.out.println(sum(transfer(intNumbers, new ArrayList<Number>())));     // The compiler infers E as Integer, and Integer :> Number
        System.out.println(sum(transfer(intNumbers, new ArrayList<Integer>())));    // The compiler infers E as Integer, and Integer :> Integer
//        System.out.println(sum(transfer(intNumbers, new ArrayList<Double>())));   // Does not compile, as the compiler infers E as Integer, and Integer !:> Double
//        System.out.println(sum(transfer(intNumbers, new ArrayList<String>())));   // Does not compile, as String is not a Number
//        Set<Object> objects = Set.of(1, "Text");
//        System.out.println(sum(transfer(objects, new ArrayList<Object>())));      // Does not compile: Proof that transfer is typesafe
        
        
    }

}
