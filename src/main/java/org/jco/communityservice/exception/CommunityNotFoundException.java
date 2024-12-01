package org.jco.communityservice.exception;

public class CommunityNotFoundException extends RuntimeException{
    public CommunityNotFoundException() {
        super("This community was not founded");
    }
}
