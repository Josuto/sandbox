package org.sandbox.patterns.adapter;

import java.util.Set;

public final class Adapter implements Target {

    private final Vendor vendor;
    
    
    public Adapter(final Vendor vendor) {
        this.vendor = vendor;
    }
    
    @Override
    public void print(Set<String> names) {
        this.vendor.print(names.iterator());
    }
    
}
