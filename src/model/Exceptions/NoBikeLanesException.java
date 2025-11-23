package model.Exceptions;

public class NoBikeLanesException extends RuntimeException {
    public NoBikeLanesException() {
        super("There are no bike lanes in this City!");
    }
}
