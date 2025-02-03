package com.example.ormlesson.exceptions;


import com.example.ormlesson.model.StatusCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final StatusCode statusCode;

    public BaseException(HttpStatus status, StatusCode statusCode) {
        super(statusCode.getMessage());
        this.status = status;
        this.statusCode = statusCode;
    }
}