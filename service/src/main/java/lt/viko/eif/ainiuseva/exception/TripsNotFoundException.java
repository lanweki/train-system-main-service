package lt.viko.eif.ainiuseva.exception;

public class TripsNotFoundException extends RuntimeException{

    private static final String TRIPS_NOT_FOUND_MESSAGE = "No routes found for %s %s-%s.";

    public TripsNotFoundException(String date, String departure, String destination) {
        super(String.format(TRIPS_NOT_FOUND_MESSAGE, date, departure, destination));
    }
}
