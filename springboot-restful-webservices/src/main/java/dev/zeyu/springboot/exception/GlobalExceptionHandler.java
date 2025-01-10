package dev.zeyu.springboot.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(
            final ResourceNotFoundException exception, final WebRequest request) {

        final Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("path", request.getDescription(false));
        body.put("error", ErrorCode.RESOURCE_NOT_FOUND.getCode());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExistsException(
            final EmailAlreadyExistsException exception, final WebRequest request) {

        final Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("path", request.getDescription(false));
        body.put("error", ErrorCode.EMAIL_ALREADY_EXISTS.getCode());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            final MethodArgumentNotValidException ex, final WebRequest request) {
        final Map<String, Object> body = new HashMap<>();

        final List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("timestamp", LocalDateTime.now());
        body.put("errors", errors);
        body.put("path", request.getDescription(false));
        body.put("error", ErrorCode.VALIDATION_FAILED.getCode());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
