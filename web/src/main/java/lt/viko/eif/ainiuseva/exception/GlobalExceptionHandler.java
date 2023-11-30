package lt.viko.eif.ainiuseva.exception;

import lt.viko.eif.ainiuseva.error.TrainSystemErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(TripsNotFoundException.class)
    public ResponseEntity<TrainSystemErrorResponse> tripsNotFoundException(TripsNotFoundException ex) {
        var message = ex.getMessage();
        var errorResponse = new TrainSystemErrorResponse(HttpStatus.NOT_FOUND.value(), message);

        logger.error(message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorResponse);
    }
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<TrainSystemErrorResponse> tripsEntityAlreadyExistException(TripsNotFoundException ex) {
        var message = ex.getMessage();
        var errorResponse = new TrainSystemErrorResponse(HttpStatus.CONFLICT.value(), message);

        logger.error(message);
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(errorResponse);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseEntity<TrainSystemErrorResponse> incorrectCredentialsException(IncorrectCredentialsException ex) {
        var message = ex.getMessage();
        var errorResponse = new TrainSystemErrorResponse(HttpStatus.UNAUTHORIZED.value(), message);

        logger.error(message);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(errorResponse);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<TrainSystemErrorResponse> noContentExceptionException(IncorrectCredentialsException ex) {
        var message = ex.getMessage();
        var errorResponse = new TrainSystemErrorResponse(HttpStatus.NO_CONTENT.value(), message);

        logger.error(message);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TrainSystemErrorResponse> handleException(Exception ex) {
        var message = ex.getMessage();
        var errorResponse = new TrainSystemErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);

        logger.error("Train system failed to handle request with the following error", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponse);
    }
}
