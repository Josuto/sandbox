package org.sandbox.patterns.adapter;

import java.util.Iterator;

public final class Vendor {

    public void print(final Iterator<String> words) {
        while (words.hasNext()) {
            String word = words.next();
            System.out.println(word);
        }
    }
    
}
