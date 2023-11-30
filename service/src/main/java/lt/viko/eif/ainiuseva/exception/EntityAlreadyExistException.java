package lt.viko.eif.ainiuseva.exception;

public class EntityAlreadyExistException extends RuntimeException{
    private static final String ENTITY_ALREADY_EXISTS_MESSAGE = "Entity already exists.";

    public EntityAlreadyExistException() {
        super(ENTITY_ALREADY_EXISTS_MESSAGE);
    }
}
