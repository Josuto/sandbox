package org.sandbox.collection.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicSetTest {

    BasicSet<String> empty, one, many;
    
    @BeforeEach
    public void setUp() {
        empty = new BasicSet<>();
        
        one = new BasicSet<>();
        one.add("A");
        
        many = new BasicSet<>();
        many.add("A");
        many.add("B");
    }
    
    @Test
    public void isEmpty() {
        assertEquals(true, empty.isEmpty());
    }
    
    @Test
    public void isNotEmpty() {
        assertEquals(false, one.isEmpty());
        assertEquals(false, many.isEmpty());
    }
    
    @Test
    public void hasOneElement() {
        assertEquals(1, one.size());
        assertEquals(true, one.contains("A"));
    }
    
    @Test
    public void hasManyElements() {
        assertEquals(true, many.size() > 1);
        assertEquals(true, many.contains("A"));
        assertEquals(true, many.contains("B"));
    }
    
    @Test
    public void removeNonexistentElement() {
        one.remove("B");
        assertEquals(false, one.isEmpty());
        assertEquals(true, many.contains("A"));
    }
    
    @Test
    public void removeExistentElement() {
        one.remove("A");
        assertEquals(true, one.isEmpty());
        
        many.remove("A");
        assertEquals(false, many.isEmpty());
        assertEquals(false, many.contains("A"));
        assertEquals(true, many.contains("B"));
        
        many.remove("B");
        assertEquals(true, many.isEmpty());
        assertEquals(false, many.contains("A"));
        assertEquals(false, many.contains("B"));
    }
    
}
