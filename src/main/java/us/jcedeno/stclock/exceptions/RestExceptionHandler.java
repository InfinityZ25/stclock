package us.jcedeno.stclock.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * A global exception handler class.
 * 
 * @author jcedeno.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ErrorResponse.builder().code(409).message(ex.getMessage()).build(),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { EmployeeNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(EmployeeNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ErrorResponse.builder().code(404).message(ex.getMessage()).build(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
