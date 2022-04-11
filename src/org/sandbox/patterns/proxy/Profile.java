package org.sandbox.patterns.proxy;

import java.util.List;

public interface Profile {

    public String getName();

    public int getLikes();

    public void incrementLikes();

    public List<String> getInterests();

    public void setInterests(final List<String> interests);
    
    public void addInterest(final String interest);
    
}
