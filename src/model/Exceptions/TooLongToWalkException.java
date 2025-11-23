package model.Exceptions;

public class TooLongToWalkException extends RuntimeException {
    public TooLongToWalkException() {
        super("This distance is too long to be walked in a day!");
    }
}
