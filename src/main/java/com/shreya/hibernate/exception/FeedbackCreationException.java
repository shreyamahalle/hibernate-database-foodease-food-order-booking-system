package com.shreya.hibernate.exception;

public class FeedbackCreationException extends RuntimeException {
    public FeedbackCreationException() {
        super("unable to add feedback");
    }

    public FeedbackCreationException(String message) {
        super(message);
    }
}
