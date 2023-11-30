package lt.viko.eif.ainiuseva.exception;

public class IncorrectCredentialsException extends RuntimeException {

    private static final String INCORRECT_CREDENTIALS_MESSAGE = "Provided username or password is incorrect.";

    public IncorrectCredentialsException() {
        super(INCORRECT_CREDENTIALS_MESSAGE);
    }
}
