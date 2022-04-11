package org.sandbox.concurrent.synchronizers.locks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLockExample {

    private final static int READERS_AMOUNT = 6;
    
    private final static int WRITERS_AMOUNT = 3;
    
    private final static int AVAILABLE_THREADS = 4;
    
    private final static ConcurrentArray<Integer> numbers = new ConcurrentArray<>(READERS_AMOUNT);
    
    
    public static void main(String[] args) {
        // Initialize numbers array
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, 0);
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(AVAILABLE_THREADS);
        
        for (int i = 0; i < WRITERS_AMOUNT; i++) {
            executor.execute(new Writer());
        }
        for (int i = 0; i < READERS_AMOUNT; i++) {
            executor.execute(new Reader(i));
        }
        executor.shutdown();
    }
    
    
    private static class Reader implements Runnable {

        private final int index;
        
        
        public Reader(final int index) {
            if (index >= numbers.size()) 
                throw new IllegalArgumentException("The given index must be smaller than the array length!"); 
            
            this.index = index;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("Read Thread "  + Thread.currentThread().getName() 
                        + ": number[" + index + "] = " + numbers.get(index));
                Thread.sleep(5);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        
    }
    
    private static class Writer implements Runnable {

        private final int index;
        
        
        public Writer() {
            this.index = new Random().nextInt(numbers.size());
        }
        
        @Override
        public void run() {
            try {
                numbers.set(index, numbers.get(index) + 1);
                System.out.println("Write Thread " + Thread.currentThread().getName() 
                        + ": number[" + index + "] = " + numbers.get(index));
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        
    }

}
