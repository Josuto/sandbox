package org.sandbox.patterns.observer;

public final class EmailClient implements Observer<Message> {

    private Observable<Message> observable;
    
    
    public EmailClient(final Observable<Message> observable) {
        this.observable = observable;
    }
    
    @Override
    public void unsubscribe() {
        this.observable.removeObserver(this);
    }
    
    @Override
    public void update() {
        Message message = this.observable.getState();
        System.out.println("You've got new email! \n  Title: " + message.getTitle() + "\n  Body: " + message.getBody());
    }
    
    @Override
    public void update(final Message message) {
        System.out.println("You've got new email! \n  Title: " + message.getTitle() + "\n  Body: " + message.getBody());
    }

}
