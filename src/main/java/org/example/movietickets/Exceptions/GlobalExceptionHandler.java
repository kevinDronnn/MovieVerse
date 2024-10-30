package org.example.movietickets.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler for all exceptions
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.1
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Method for throwing exception when location not found
     * @param ex for getting message of exception
     * @return message of exception and 404 status
     * @see LocationNotFoundException
     */
    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleLocationNotFoundException(LocationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Method for throwing exception when we get wrong argument in parameters
     * @param ex for getting message of exception
     * @return message of exception and 400 status
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Method for throwing exception when we can`t find entity in database
     * @param ex for getting message of exception
     * @return message of exception and 404 status
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>("No movies found in your city", HttpStatus.NOT_FOUND);
    }

    /**
     * Method for throwing unexpected error
     * @param ex for getting message of exception
     * @return message of exception and 500 status
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
