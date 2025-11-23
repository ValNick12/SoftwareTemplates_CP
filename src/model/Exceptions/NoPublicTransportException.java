package model.Exceptions;

public class NoPublicTransportException extends RuntimeException {
    public NoPublicTransportException() {
        super("There is no Public Transport for this City!");
    }
}
