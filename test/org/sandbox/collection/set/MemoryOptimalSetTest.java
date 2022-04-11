package org.sandbox.collection.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryOptimalSetTest {
    
    private static final String ELEM1 = "elem1", ELEM2 = "elem2", ELEM3 = "elem3";
    
    
    @Test
    public void sizeOfEmptySetIsZero() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        assertEquals(set.isEmpty(), true);
    }
    
    @Test
    public void setContainsElement() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        set.add(ELEM1);
        
        boolean result = set.contains(ELEM1);
        
        assertEquals(result, true);
    }
    
    @Test
    public void setDoesNotContainElement() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        set.add(ELEM1);
        
        boolean result = set.contains(ELEM2);
        
        assertEquals(result, false);
    }
    
    @Test
    public void addOneElementToSet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        set.add(ELEM1);
        
        assertEquals(set.size(), 1);
        assertTrue(set.contains(ELEM1));
    }
    
    @Test
    public void addExistingElementsToSet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        set.add(ELEM1);
        set.add(ELEM1);
        
        assertEquals(set.size(), 1);
        assertTrue(set.contains(ELEM1));
    }
    
    @Test
    public void addTwoElementsToSet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        set.add(ELEM1);
        set.add(ELEM2);
        
        assertEquals(set.size(), 2);
        assertTrue(set.contains(ELEM1));
        assertTrue(set.contains(ELEM2));
    }
    
    @Test
    public void addThreeElementsToSet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        set.add(ELEM1);
        set.add(ELEM2);
        set.add(ELEM3);
        
        assertEquals(set.size(), 3);
        assertEquals(set.arrayLength(), 4); // this assertion fails if Set.INITIAL_CAPACITY changes
        assertTrue(set.contains(ELEM1));
        assertTrue(set.contains(ELEM2));
        assertTrue(set.contains(ELEM3));
    }
    
    @Test
    public void cannotRemoveElementFromEmptySet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        
        set.remove(ELEM1);
        
        assertEquals(set.size(), 0);
        assertFalse(set.contains(ELEM1));
    }
    
    @Test
    public void removeExistingElementFromEmptySet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        set.add(ELEM1);
        
        set.remove(ELEM1);
        
        assertEquals(set.size(), 0);
        assertFalse(set.contains(ELEM1));
    }
    
    @Test
    public void removeExistingElementFromPopulatedSet() {
        MemoryOptimalSet<String> set = new MemoryOptimalSet<>();
        set.add(ELEM1);
        set.add(ELEM2);
        set.add(ELEM3);
        
        set.remove(ELEM1);
        
        assertEquals(set.size(), 2);
        assertEquals(set.arrayLength(), 2); // this assertion fails if Set.INITIAL_CAPACITY changes
        assertFalse(set.contains(ELEM1));
        assertTrue(set.contains(ELEM2));
        assertTrue(set.contains(ELEM3));
    }

}
