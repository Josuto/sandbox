package org.sandbox.patterns.observer;

public final class Newspaper extends Observable<Message> {

    private Message message;
    
    
    @Override
    public Message getState() {
        return this.message;
    }

    public void setMessage(final Message message) {
        this.message = message;
        this.messageChanged();
    }
    
    private void messageChanged() {
        this.setChanged();
        this.notifyObservers(message);
    }
    
}
