package com.lcwd.hotel.exception;

import com.lcwd.hotel.payload.Apiresponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Apiresponse> handleResourceNotFoundException(ResourceNotFoundException ex){

        String message= ex.getMessage();

        Apiresponse response = new Apiresponse();
        response.setMessage(message);
        response.setSuccess(true);
        response.setStatus(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
