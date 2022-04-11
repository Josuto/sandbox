package org.sandbox.nested.classes;

public class ClassWithStaticClassMember {

    public static int number = 0;
    
    
    // Static class member that specifies non-final static members
    public static class StaticClassMember {
    
        // Proof that a static class member can specify non-final static class fields
        private static String string = "Peter";
    
        
        // Proof that a static class member can specify non-final static methods
        public static String getString() {
            return string;
        }
        
    }
    
}
