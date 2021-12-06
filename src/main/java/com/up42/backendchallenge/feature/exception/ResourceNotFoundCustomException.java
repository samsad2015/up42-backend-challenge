package com.up42.backendchallenge.feature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundCustomException extends RuntimeException {
    public ResourceNotFoundCustomException() {
        super();
    }

    public ResourceNotFoundCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundCustomException(String message) {
        super(message);
    }

    public ResourceNotFoundCustomException(Throwable cause) {
        super(cause);
    }
}