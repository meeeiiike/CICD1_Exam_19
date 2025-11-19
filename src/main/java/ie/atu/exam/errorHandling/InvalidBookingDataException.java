package ie.atu.exam.errorHandling;

public class InvalidBookingDataException extends RuntimeException{
    private String field;

    public InvalidBookingDataException(String message, String field) {
        super(message);
        this.field = field;
    }
    public InvalidBookingDataException(String message) {
        super(message);
    }
    // Assuming this is a custom exception class for the validation annotations, not sure if correct and how to implement will return if time.
}
