package ie.atu.exam.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDetails>> showErrorDetails(MethodArgumentNotValidException me) {
        List<ExceptionDetails> errorList = new ArrayList<>();
        for(FieldError fieldError : me.getBindingResult().getFieldErrors()) {
            errorList.add(new ExceptionDetails(fieldError.getField(), fieldError.getDefaultMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }
    @ExceptionHandler(DuplicateRegNumberException.class)
    public ResponseEntity<ExceptionDetails> showDupeError(DuplicateRegNumberException de) {
        ExceptionDetails exDetails = new ExceptionDetails("Registration number ", de.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exDetails);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ExceptionDetails> showDupeError(BookingNotFoundException be) {
        ExceptionDetails exDetails = new ExceptionDetails("Registration number ", be.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exDetails);
    }

}
