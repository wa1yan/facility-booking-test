package dev.waiyanhtet.facilitybookingtest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessLogicException extends RuntimeException {

    private final int code;
    private final HttpStatus httpStatus;

    public BusinessLogicException(HttpStatus httpStatus, int code, String message) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
