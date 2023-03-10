package io.github.nilsonsasaki.exception.domain;

public class IllegalNullArgumentException extends IllegalArgumentException {
    public IllegalNullArgumentException(String argument) {
        super(argument + " cannot be null");
    }
}
