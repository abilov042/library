package com.example.ormlesson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorDataResult {

    private int statusCode;
    private String message;
    private List<String> data;

    public ErrorDataResult(int statusCode, String message,List<String> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


}
