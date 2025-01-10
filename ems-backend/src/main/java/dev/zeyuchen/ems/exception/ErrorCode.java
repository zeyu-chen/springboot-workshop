package dev.zeyuchen.ems.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    RESOURCE_NOT_FOUND("NOT_FOUND", HttpStatus.NOT_FOUND), BAD_REQUEST("BAD_REQUEST",
            HttpStatus.BAD_REQUEST), VALIDATION_ERROR("VALIDATION_ERROR",
                    HttpStatus.BAD_REQUEST), INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR",
                            HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final HttpStatus status;
}
