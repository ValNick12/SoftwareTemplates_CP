package model.Exceptions;

public class NoBikeLanesException extends RuntimeException {
    public NoBikeLanesException(String message) {
        super(message);
    }
}
