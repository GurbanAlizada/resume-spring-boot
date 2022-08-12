package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmploymentHistoryNotFoundException extends RuntimeException{

    public EmploymentHistoryNotFoundException(String message) {
        super(message);
    }

}
