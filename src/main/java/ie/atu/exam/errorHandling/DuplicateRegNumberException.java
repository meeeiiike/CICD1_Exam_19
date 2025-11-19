package ie.atu.exam.errorHandling;

public class DuplicateRegNumberException extends RuntimeException{
    private String field;

    public DuplicateRegNumberException(String message, String field) {
        super(message);
        this.field = field;
    }
    public DuplicateRegNumberException(String message) {
        super(message);
    }
}
