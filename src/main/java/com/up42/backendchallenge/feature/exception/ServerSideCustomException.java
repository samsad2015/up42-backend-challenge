package com.up42.backendchallenge.feature.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerSideCustomException extends RuntimeException{
    public ServerSideCustomException() {
        super();
    }

    public ServerSideCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerSideCustomException(String message) {
        super(message);
    }

    public ServerSideCustomException(Throwable cause) {
        super(cause);
    }
}
