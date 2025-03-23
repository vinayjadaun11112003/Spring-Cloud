package com.user.service.exception;

import com.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(ResourceNotFountException.class)
     public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFountException ex)
     {
          String message = ex.getMessage();
          ApiResponse response = new ApiResponse();
          response.setMessage(message);
          response.setSuccess(true);
          response.setStatus(HttpStatus.NOT_FOUND);

          return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
     }
}
