package com.jpl.easyrider.web.error;

public class IncorrectNameException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "The provided name is too short";

    public IncorrectNameException() {
        super(EXCEPTION_MESSAGE);
    }
}
