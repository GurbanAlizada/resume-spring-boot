package com.company.advice;

import com.company.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ExceptionResponse> illegalException(Exception exception ,
                                                                    WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now() ,"2000" , exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse , HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> userNotFound(Exception exception ,
                                                                    WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now() ,"3000" , exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse , HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> exception(Exception exception ,
                                                                    WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now() ,"4000" , exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse , HttpStatus.EXPECTATION_FAILED);
    }




}
