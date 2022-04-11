package org.sandbox.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    Map<String, Integer> empty, one, many;
    
    @BeforeEach
    private void setup() {
        empty = new HashMap<>();
        
        one = new HashMap<>();
        one.put("First", 1);
        
        many = new HashMap<>();
        many.put("First", 1);
        many.put("Second", 2);
        many.put("Third", 3);
    }
    
    @Test
    public void isEmptyTest() {
        assertTrue(empty.isEmpty());
    }
    
    @Test
    public void isNotEmptyTest() {
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
    }
    
    @Test
    public void hasExactlyOneEntryTest() {
        assertEquals(1, one.size());
        assertTrue(one.containsKey("First"));
        assertEquals(1, one.get("First"));
    }
    
    @Test
    public void hasNotEntryTest() {
        assertFalse(one.containsKey("Null"));
        assertEquals(null, one.get("Null"));
    }
    
    @Test
    public void nullKeyLookupTest() {
        assertThrows(IllegalArgumentException.class, 
                () -> one.containsKey(null));
    }
    
    @Test
    public void putNonexistentKeyEntryTest() {
        one.put("Second", 2);
        assertEquals(2, one.size());
        assertTrue(one.containsKey("Second"));
        assertEquals(2, one.get("Second"));
    }
    
    @Test
    public void putExistentKeyEntryTest() {
        one.put("First", 2);
        assertEquals(1, one.size());
        assertTrue(one.containsKey("First"));
        assertEquals(2, one.get("First"));
    }
    
    @Test
    public void containsValueTest() {
        assertTrue(one.containsValue(1));
    }
    
    @Test
    public void doesNotcontainValueTest() {
        assertFalse(one.containsValue(2));
    }
    
    @Test
    public void removeExistentEntryTest() {
        assertEquals(1, one.remove("First"));
        assertEquals(0, one.size());
        
        assertEquals(2, many.remove("Second"));
        assertEquals(2, many.size());
    }
    
    @Test
    public void removeNonexistentEntryTest() {
        assertEquals(null, empty.remove("First"));
        assertEquals(0, empty.size());
        
        assertEquals(null, one.remove("Second"));
        assertEquals(1, one.size());
        
        assertEquals(null, many.remove("Fourth"));
        assertEquals(3, many.size());
    }
    
    @Test
    public void clearTest() {
        empty.clear();
        assertEquals(0, empty.size());
        
        one.clear();
        assertEquals(0, one.size());
        assertFalse(one.containsValue(1));
        
        many.clear();
        assertEquals(0, many.size());
        assertFalse(many.containsValue(1));
        assertFalse(many.containsValue(2));
        assertFalse(many.containsValue(3));
    }
    
    @Test
    public void entrySetTest() {
        assertEquals(new HashSet<>(), empty.entrySet());
        
        Set<Entry<String, Integer>> oneElemSet = new HashSet<>();
        oneElemSet.add(new SimpleEntry<>("First", 1));
        assertEquals(oneElemSet, one.entrySet());
        
        Set<Entry<String, Integer>> manyElemSet = new HashSet<>();
        manyElemSet.add(new SimpleEntry<>("First", 1));
        manyElemSet.add(new SimpleEntry<>("Second", 2));
        manyElemSet.add(new SimpleEntry<>("Third", 3));
        assertEquals(manyElemSet, many.entrySet());
    }
    
    @Test
    public void putAllFromEmptyMapToOneElemMapTest() {
        one.putAll(empty);
        assertEquals(1, one.size());
        assertEquals(1, one.get("First"));
    }
    
    @Test
    public void putAllFromOneMapToEmptyMapTest() {
        empty.putAll(one);
        assertEquals(1, empty.size());
        assertEquals(1, empty.get("First"));
    }
    
    @Test
    public void putAllFromManyElemMapToOneElemMapTest() {
        one.putAll(many);
        assertEquals(3, one.size());
        assertEquals(1, one.get("First"));
        assertEquals(2, one.get("Second"));
        assertEquals(3, one.get("Third"));
    }
    
    @Test
    public void putAllFromSingleNewElemMapToManyElemMapTest() {
        Map<String, Integer> newOne = new HashMap<>();
        newOne.put("Fourth", 4);
        
        many.putAll(newOne);
        assertEquals(4, many.size());
        assertEquals(1, many.get("First"));
        assertEquals(2, many.get("Second"));
        assertEquals(3, many.get("Third"));
        assertEquals(4, many.get("Fourth"));
    }
    
    @Test
    public void keySetTest() {
        assertEquals(Set.of(), empty.keySet());
        
        assertEquals(Set.of("First"), one.keySet());
        
        assertEquals(Set.of("First", "Second", "Third"), many.keySet());
    }
    
    @Test
    public void valuesTest() {
        assertEquals(Set.of(), empty.values());
        
        assertEquals(Set.of(1), one.values());
        
        assertEquals(Set.of(1, 2, 3), many.values());
    }
    
}
