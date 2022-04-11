package org.sandbox.patterns.observer;

import java.util.stream.Stream;

public final class JournalistMain {

    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();
        
        Message message1 = new Message("Free Candies", "All candies in the world are now free!");
        Message message2 = new Message("Rubber President", "A rubber is now the new president");
        Message message3 = new Message("Payed for Sleeping", "A man gets payed for sleeping");
        
        SmartPhone phone = new SmartPhone(newspaper);
        EmailClient emailClient = new EmailClient(newspaper);
        
        Stream.of(phone, emailClient).forEach(newspaper::addObserver);
        
        newspaper.setMessage(message1);
        
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        
        newspaper.setMessage(message2);
        
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        
        phone.unsubscribe();
        
        newspaper.setMessage(message3);
    }

}
