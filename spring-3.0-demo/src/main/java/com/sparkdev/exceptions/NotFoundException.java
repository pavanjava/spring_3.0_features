package com.sparkdev.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException{
    private HttpStatus statusCode;
    private String message;
    @Override
    public String getMessage() {
        return message;
    }
}
