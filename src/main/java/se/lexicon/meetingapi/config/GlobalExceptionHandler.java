package se.lexicon.meetingapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorDetails(ex.getMessage());
    }
}

class ErrorDetails {
    private String message;

    public ErrorDetails(String message) {
        this.message = message;
    }

    // Getters and setters
}

