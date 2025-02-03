package com.example.ormlesson.advice;

import com.example.ormlesson.exceptions.BaseException;
import com.example.ormlesson.model.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResult> handleBaseException(BaseException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(
                new ErrorResult(e.getStatusCode().getCode(),
                        e.getStatusCode().getMessage()));
    }

}
