package io.github.nilsonsasaki.generic.exception;

public class IllegalNullArgumentException extends IllegalArgumentException {
    public IllegalNullArgumentException(String argument) {
        super(argument + " cannot be null");
    }
}
