package org.jco.communityservice.domain;

public class CommunityNotFoundException extends RuntimeException{
    public CommunityNotFoundException() {
        super("This community was not founded");
    }
}
