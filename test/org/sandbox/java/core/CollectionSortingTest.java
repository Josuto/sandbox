package org.sandbox.java.core;

import org.junit.jupiter.api.Test;
import org.sandbox.util.Person;
import org.sandbox.util.user.NormalUser;
import org.sandbox.util.user.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CollectionSortingTest {

    @Test
    public void testPeopleSort() {
        Person[] unorderedArray = {
            new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3)), 
            new Person("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7)),
            new Person("Zoe",   "Smith",   LocalDate.of(2020, 4,  29)), 
            new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17)),
            new Person("Zoe",   "Bale",    LocalDate.of(2020, 4,  28))
        };
        
        Person[] naturallyOrderedArray = {
            new Person("Zoe",   "Bale",    LocalDate.of(2020, 4,  28)),
            new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17)),
            new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3)), 
            new Person("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7)),
            new Person("Zoe",   "Smith",   LocalDate.of(2020, 4,  29)) 
        };
        
        SortedSet<Person> set = new TreeSet<>(Arrays.asList(unorderedArray));
        
        /*
         * Hack required to validate that the contents of the set under test are ordered
         * by age. Since (1) if the expected object was another Set (i.e., SortedSet)
         * this test would provide false positives due to the fact that Set imposes the
         * constraint that two sets that include the same elements are equal and (2) we
         * cannot compare a Set with a List directly.
         */
        List<Person> expectedList = Arrays.asList(naturallyOrderedArray);
        Iterator<Person> expectedListIterator = expectedList.iterator();
        for (Iterator<Person> setIterator = set.iterator(); setIterator.hasNext();) {
            Person expectedPerson = expectedListIterator.next(); 
            
            assertEquals(expectedPerson, setIterator.next());
        }
    }
    
    @Test
    public void testPeopleSortByAge() {
        Person[] unorderedArray = {
            new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3)), 
            new Person("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7)),
            new Person("Zoe",   "Smith",   LocalDate.of(2020, 4,  29)), 
            new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17)),
            new Person("Zoe",   "Bale",    LocalDate.of(2020, 4,  28))
        };
        
        Person[] arrayOrderedByAge = {
            new Person("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7)),
            new Person("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3)), 
            new Person("Aaron", "Kravitz", LocalDate.of(2005, 2,  17)),
            new Person("Zoe",   "Bale",    LocalDate.of(2020, 4,  28)),
            new Person("Zoe",   "Smith",   LocalDate.of(2020, 4,  29)) 
        };
        
        SortedSet<Person> set = new TreeSet<>((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday()));
        set.addAll(Arrays.asList(unorderedArray));

        /*
         * Hack required to validate that the contents of the set under test are ordered
         * by age. Since (1) if the expected object was another Set (i.e., SortedSet)
         * this test would provide false positives due to the fact that Set imposes the
         * constraint that two sets that include the same elements are equal and (2) we
         * cannot compare a Set with a List directly.
         */
        List<Person> expectedList = Arrays.asList(arrayOrderedByAge);
        Iterator<Person> expectedListIterator = expectedList.iterator();
        for (Iterator<Person> setIterator = set.iterator(); setIterator.hasNext();) {
            Person expectedPerson = expectedListIterator.next(); 
            
            assertEquals(expectedPerson, setIterator.next());
        }
    }
    
    @Test
    public void testUserSortByAge() {
        User[] unorderedArray = {
            new NormalUser("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3),  "zoe.kravitz"), 
            new NormalUser("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7),  "zkravitz"),
            new NormalUser("Zoe",   "Smith",   LocalDate.of(2020, 4,  29), "smith"), 
            new NormalUser("Aaron", "Kravitz", LocalDate.of(2005, 2,  17), "aaron"),
            new NormalUser("Zoe",   "Bale",    LocalDate.of(2020, 4,  28), "bale")
        };
        
        User[] arrayOrderedByAge = {
            new NormalUser("Zulu",  "Kravitz", LocalDate.of(1953, 10, 7),  "zkravitz"),
            new NormalUser("Zoe",   "Kravitz", LocalDate.of(2000, 5,  3),  "zoe.kravitz"), 
            new NormalUser("Aaron", "Kravitz", LocalDate.of(2005, 2,  17), "aaron"),
            new NormalUser("Zoe",   "Bale",    LocalDate.of(2020, 4,  28), "bale"),
            new NormalUser("Zoe",   "Smith",   LocalDate.of(2020, 4,  29), "smith")
        };
        
        List<User> list = Arrays.asList(unorderedArray);
        List<User> expectedList = Arrays.asList(arrayOrderedByAge);
        
        list.sort(User::compareByAge);
//        Collections.sort(list, User::compareByAge); // Synonym of the former
//        unorderedList.sort((u1, u2) -> User.compareByAge(u1, u2)); // Synonym of the former
        
        assertEquals(expectedList, list);
    }
    
}
