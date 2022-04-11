package org.sandbox.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * The goal of this class is to exercise some of the notions around concurrent
 * programming, primarily: synchronization, mutual exclusion via variable or
 * method atomicity, and safe inter-thread communication of shared data. These
 * notions prevent some of the most well known race conditions i.e., liveness
 * and safety failures.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public final class SynchronizationBasics {

    /**
     * Determines when a thread must stop its operation. This field is designed to
     * prevent liveness failure.
     * <p>
     * Since the boolean primitive type is atomic by default, we just need to enable
     * reliable multi-thread communication via the 'volatile' modifier so that it is
     * visible to all threads.
     */
    private static volatile boolean stopThread; // initialized to false by default
    
    /**
     * The instance of {@link WholeNumber} to play with. 
     */
    private static final WholeNumber<Integer> wholeNumber = new WholeNumber<>(0);
    

    /**
     * First increments by one the value of the given {@link WholeNumber} and then
     * prints it prefixing the given message.
     * <p>
     * This method must be synchronized to ensure mutual exclusion; even if
     * {@link WholeNumber#increment()} is thread-safe (i.e., it is atomic and
     * enables reliable multi-thread communication), this method is not atomic
     * without adding the 'synchronized' modifier. Thus, without proper
     * synchronization, its operations may be interleaved in a concurrent
     * environment, causing non-sequential increment printing. If sequentiality is
     * not a requirement, we could safely remove the 'synchronized' modifier.
     * 
     * @param number
     *            the {@link WholeNumber} which value is to be printed.
     * @param message
     *            the prefixed message.
     */
    private static synchronized <N extends Number> void incrementPrint(
            final WholeNumber<N> number, 
            final String message) {
        System.out.println(message + " = " + number.increment());
    }
    
    /**
     * Starts a second thread that increments the value of the {@link WholeNumber}
     * field and prints such values, considering that the actual thread also does
     * the same thing i.e., both threads share the instance of {@link WholeNumber}.
     * After some given time, the actual thread requests the second thread to stop.
     * <p>
     * Requirement: all values must be printed sequentially.
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Thread declaration
        Thread thread = new Thread(() -> {
            while(!stopThread) { // thread control
                incrementPrint(wholeNumber, "number according to SECOND thread");
            }
        });
        // Program execution
        System.out.println("number according to FIRST thread BEFORE start of second thread = " + wholeNumber.getNumber());
        thread.start();
        incrementPrint(wholeNumber, "number according to FIRST thread AFTER start of second thread");
        TimeUnit.MICROSECONDS.sleep(1);
        stopThread = true; // thread control
        System.out.println("number according to FIRST thread AFTER requesting the end of second thread = " + wholeNumber.getNumber());
    }

}
