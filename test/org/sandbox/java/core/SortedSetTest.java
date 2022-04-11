package org.sandbox.java.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public final class SortedSetTest {

    @Test
    public void testSubSet() {
        String[] diccionary = {
                "alert", "all", "beer", "bake", "car", "create", "dice", "donkey", "eel", "elect"
        };
        
        SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList(diccionary));

        String[] extract = {
                "bake", "beer", "car", "create"
        };
        
        SortedSet<String> sortedSubSet = sortedSet.subSet("bake", "create\0");
        assertEquals(Arrays.asList(extract).toString(), sortedSubSet.toString());
        
        sortedSubSet = sortedSet.subSet("b", "d");
        assertEquals(Arrays.asList(extract).toString(), sortedSubSet.toString());
        
    }
    
}
