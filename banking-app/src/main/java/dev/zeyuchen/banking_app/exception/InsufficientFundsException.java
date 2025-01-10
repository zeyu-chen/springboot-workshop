package dev.zeyuchen.banking_app.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(final String message) {
        super(message);
    }
}
