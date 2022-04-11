package org.sandbox.patterns.observer;

public final class Message {

    private final String title;
    
    private final String body;
    
    
    public Message(final String title, final String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }
    
}
