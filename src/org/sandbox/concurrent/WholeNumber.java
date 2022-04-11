package org.sandbox.concurrent;

/**
 * Wrapper of a Java Integer or Long whole number that also specifies some
 * operations with side-effects over the wrapped number. Byte and Short, types
 * that also model a whole number in Java, are left out for simplicity purposes.
 * <p>
 * Instances of {@link WholeNumber} may be accessed in a concurrent environment.
 * Since its unique field is mutable, to guarantee state consistency and
 * inter-thread visibility, all accessor and mutator methods must be
 * synchronized.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 * @param <N>
 *            the type of the wrapped whole number.
 */
public final class WholeNumber<N extends Number> {
    
    private N number;
    
    
    public WholeNumber(final N number) {
        // Precondition
        if (!(number instanceof Integer) || (number instanceof Long))
            throw new IllegalArgumentException(
                    "The type of the given number is not of an accepted whole number type");
        this.number = number;
    }
    
    public synchronized N getNumber() {
        return this.number;
    }
    
    public synchronized N increment() {
        if (this.number instanceof Integer) {
            @SuppressWarnings("unchecked") // It is safe to cast to N as Integer satisfies the class invariant specified above
            N integerValue = (N) Integer.valueOf(this.number.intValue() + 1); 
            this.number = integerValue;
        }
        else {
            @SuppressWarnings("unchecked") // It is safe to cast to N as Long satisfies the class invariant specified above
            N longValue = (N) Long.valueOf(this.number.longValue() + 1);
            this.number = longValue;
        }
        return this.number;
    }

}
