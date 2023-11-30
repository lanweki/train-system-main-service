package lt.viko.eif.ainiuseva.exception;

public class NoContentException extends RuntimeException {

    private static final String NO_CONTENT_MESSAGE = "Requested data was not found.";

    public NoContentException() {
        super(NO_CONTENT_MESSAGE);
    }
}
