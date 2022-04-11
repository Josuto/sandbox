package org.sandbox.patterns.proxy;

import java.lang.reflect.Proxy;
import java.util.List;

public final class ProxyClientMain {

    public static void main(String[] args) {
        Profile profile = new ProfileImpl("Joe", List.of("Do only maths"));

        // Create owner profile proxy and invoke its methods
        Profile ownerProfileProxy = (Profile) Proxy.newProxyInstance(
                profile.getClass().getClassLoader(), 
                profile.getClass().getInterfaces(), 
                new ProfileOwnerInvocationHandler(profile));
        
        ownerProfileProxy.addInterest("Get angry with the Irish");
        try {
            ownerProfileProxy.incrementLikes();
        }
        catch (Exception exception) {
            System.out.println(exception.getCause().getMessage());
        }
        
        // Create visitor profile proxy and invoke its methods
        Profile visitorProfileProxy = (Profile) Proxy.newProxyInstance(
                profile.getClass().getClassLoader(), 
                profile.getClass().getInterfaces(), 
                new ProfileVisitorInvocationHandler(profile));
        
        try {
            visitorProfileProxy.addInterest("Make coffee with strange beans");
        }
        catch (Exception exception) {
            System.out.println(exception.getCause().getMessage());
        }
        visitorProfileProxy.incrementLikes();
    }

}
