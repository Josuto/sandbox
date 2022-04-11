package org.sandbox.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class ProfileOwnerInvocationHandler implements InvocationHandler {

    private final Profile profile;
    
    
    public ProfileOwnerInvocationHandler(final Profile profile) {
        this.profile = profile;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("incrementLikes")) {
            throw new IllegalAccessException("The profile owner cannot increment her amount of likes!");
        }
        else {
            return method.invoke(this.profile, args);
        }
    }

}
