package us.jcedeno.stclock.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import us.jcedeno.stclock.exceptions.types.EmployeeNotClockedInException;
import us.jcedeno.stclock.exceptions.types.EmployeeNotFoundException;

/**
 * A global exception handler class. This is probably not the optimal way of
 * handling exceptions, but it is sufficent for now.
 * 
 * @author jcedeno.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ErrorResponse.builder().code(HttpStatus.CONFLICT.value()).message(ex.getMessage()).build(),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { EmployeeNotFoundException.class, EmployeeNotClockedInException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ErrorResponse.builder().code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
