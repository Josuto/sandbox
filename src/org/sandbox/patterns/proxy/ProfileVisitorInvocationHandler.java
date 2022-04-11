package org.sandbox.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class ProfileVisitorInvocationHandler implements InvocationHandler {

    private Profile profile;
    
    
    public ProfileVisitorInvocationHandler(final Profile profile) {
        this.profile = profile;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set") || method.getName().startsWith("add")) {
            throw new IllegalAccessException(
                    "A profile visitor cannot change values of the properties of a profile that is not his!");
        }
        else {
            return method.invoke(this.profile, args);
        }
    }

}
