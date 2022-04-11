package org.sandbox.patterns.adapter;

import java.util.Set;

public final class Client {
    
    private Target api;
    
    
    public Client(final Target api) {
        this.api = api;
    }
    
    public void print(final Set<String> names) {
        this.api.print(names);
    }

}
