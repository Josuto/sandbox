package org.sandbox.util;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public final class PersonTest {

    @Test
    public void compareTo_NullPerson_NullPointerException() {
        Person person = new Person("Zoe", "Kravitz", LocalDate.of(2000, 5,  3));
        
        assertThrows(NullPointerException.class, () -> person.compareTo(null));
    }
    
    @Test
    public void compareTo_PersonWithSameNameAndSurname_Zero() {
        Person person1 = new Person("Zoe", "Kravitz", LocalDate.of(2000, 5,  3));
        Person person2 = new Person("Zoe", "Kravitz", LocalDate.of(2000, 5,  3));
        
        assertTrue(person1.compareTo(person2) == 0);
    }
    
    @Test
    public void compareTo_PersonWithSameNameAndDescendentSurname_Negative() {
        Person person1 = new Person("Zoe", "Kravitz", LocalDate.of(2000, 5,  3));
        Person person2 = new Person("Zoe", "Smith",   LocalDate.of(2020, 4,  29));
        
        assertTrue(person1.compareTo(person2) < 0);
    }
    
    @Test
    public void compareTo_PersonWithSameNameAndAscendentSurname_Positive() {
        Person person1 = new Person("Zoe", "Kravitz", LocalDate.of(2000, 5,  3));
        Person person2 = new Person("Zoe", "Bale",    LocalDate.of(2020, 4,  28));
        
        assertTrue(person1.compareTo(person2) > 0);
    }
    
    @Test
    public void compareTo_PersonWithDescendentNameAndSameSurname_Negative() {
        Person person1 = new Person("Zoe",  "Kravitz", LocalDate.of(2000, 5,  3));
        Person person2 = new Person("Zulu", "Kravitz", LocalDate.of(1953, 10, 7));
        
        assertTrue(person1.compareTo(person2) < 0);
    }
    
    @Test
    public void compareTo_PersonWithAscendentNameAndSameSurname_Positive() {
        Person person1 = new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3));
        Person person2 = new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17));
        
        assertTrue(person1.compareTo(person2) > 0);
    }
    
    
    @ParameterizedTest
    @MethodSource("compareToDataProvider")
    public void compareToWithDataProvider(
            final Person person, 
            final Person anotherPerson, 
            final Numbers expectedResult) {
        assertTrue(expectedResult.isTrue(person.compareTo(anotherPerson)));
    }
    
    private static Stream<Arguments> compareToDataProvider() {
        Person zoeKravitz =   new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3)),
               zoeSmith =     new Person("Zoe",   "Smith",   LocalDate.of(2020, 4,  29)),
               zoeBale =      new Person("Zoe",   "Bale",    LocalDate.of(2020, 4,  28)),
               zuluKravitz =  new Person("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7)),
               aaronKravitz = new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17));
        
        return Stream.of(
            arguments(zoeKravitz, zoeKravitz,   Numbers.ZERO), 
            arguments(zoeKravitz, zoeSmith,     Numbers.NEGATIVE),
            arguments(zoeKravitz, zoeBale,      Numbers.POSITIVE),
            arguments(zoeKravitz, zuluKravitz,  Numbers.NEGATIVE),
            arguments(zoeKravitz, aaronKravitz, Numbers.POSITIVE)
        );
    }
    
    private enum Numbers {
        
        ZERO {
            @Override
            boolean isTrue(int number) {
                return number == 0;
            }
        }, 
        POSITIVE {
            @Override
            boolean isTrue(int number) {
                return number > 0;
            }
        }, 
        NEGATIVE {
            @Override
            boolean isTrue(int number) {
                return number < 0;
            }
        };
        
        abstract boolean isTrue(final int number);
        
    }
    
}
