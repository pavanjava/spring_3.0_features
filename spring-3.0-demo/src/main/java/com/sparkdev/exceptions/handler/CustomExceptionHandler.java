package com.sparkdev.exceptions.handler;

import com.sparkdev.exceptions.NotFoundException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail onNotFoundException(NotFoundException notFoundException){
        return ProblemDetail.forStatusAndDetail(notFoundException.getStatusCode(), notFoundException.getMessage());
    }
}
