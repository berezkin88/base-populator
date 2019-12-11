package de.adorsys.basepopulator.exception;

import de.adorsys.basepopulator.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandlerAdvisor {
    private static final Logger logger = Logger.getLogger(ExceptionHandlerAdvisor.class.getName());

    private static final String EXCEPTION_ERROR_MESSAGE = "Server error";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception ex) {
        return handle(ex, EXCEPTION_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> handle(Exception ex, String errorMessage, HttpStatus httpStatus) {
        logError(ex);
        return ResponseEntity
            .status(httpStatus)
            .body(new ErrorResponse(List.of(errorMessage)));
    }

    private void logError(Exception exception) {
        String errorMessage = exception.getMessage() == null ? "" : exception.getMessage();
        logger.log(Level.SEVERE, errorMessage, exception);
    }
}
