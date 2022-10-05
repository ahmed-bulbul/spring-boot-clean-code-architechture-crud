package com.bulbul.crud.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
    }

    public ApiError(HttpStatus badRequest) {
        this.status = badRequest;
    }

    public <R> void addValidationErrors(R collect) {
        this.errors = Arrays.asList(collect.toString());
    }
}