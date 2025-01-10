package dev.zeyuchen.ems.exception;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            final ResourceNotFoundException exception, final WebRequest webRequest) {

        final ErrorDetails errorDetails =
                new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
                        webRequest.getDescription(false), ErrorCode.RESOURCE_NOT_FOUND.getCode());

        return new ResponseEntity<>(errorDetails, ErrorCode.RESOURCE_NOT_FOUND.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(final Exception exception,
            final WebRequest webRequest) {

        final ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                exception.getMessage(), webRequest.getDescription(false),
                ErrorCode.INTERNAL_SERVER_ERROR.getCode());

        return new ResponseEntity<>(errorDetails, ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
    }
}
