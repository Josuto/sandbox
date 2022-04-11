package org.sandbox.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public final class ProfileImpl implements Profile {
    
    private final String name;
    
    private int likes;
    
    private List<String> interests;
    
    
    public ProfileImpl(final String name, final List<String> interests) {
        this.name = name;
        this.likes = 0;
        this.interests = new ArrayList<>(interests);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLikes() {
        return this.likes;
    }

    @Override
    public void incrementLikes() {
        this.likes++;
    }

    @Override
    public List<String> getInterests() {
        return this.interests;
    }
    
    @Override
    public void setInterests(final List<String> interests) {
        this.interests = interests;
    }
    
    @Override
    public void addInterest(final String interest) {
        this.interests.add(interest);
    }

}
