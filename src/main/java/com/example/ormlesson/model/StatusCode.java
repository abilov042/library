package com.example.ormlesson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {
    USER_NOT_FOUND(1001, "User not found"),
    BOOK_NOT_FOUND(1002, "Book not found"),;

    private final int code;
    private final String message;

}
