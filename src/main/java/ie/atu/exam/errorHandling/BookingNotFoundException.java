package ie.atu.exam.errorHandling;

public class BookingNotFoundException extends RuntimeException{
    private String field;

    public BookingNotFoundException(String message, String field) {
        super(message);
        this.field = field;
    }
    public BookingNotFoundException(String message) {
        super(message);
    }
}
