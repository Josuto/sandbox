package org.sandbox.patterns.adapter;

import java.util.Set;

public final class ClientTestMain {

    public static void main(String[] args) {
        Set<String> names = Set.of("peter", "john", "emma", "johana");
        Target api = new Adapter(new Vendor());
        
        Client client = new Client(api);
        client.print(names);
    }

}
