package dev.zeyu.springboot.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"), EMAIL_ALREADY_EXISTS(
            "EMAIL_ALREADY_EXISTS"), VALIDATION_FAILED("VALIDATION_FAILED");

    private final String code;
}
