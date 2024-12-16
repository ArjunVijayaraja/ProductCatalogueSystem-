package com.example.productCatalogSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleProductNameAlreadyExistException(ProductAlreadyExistException exception,
                                                                               WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "PRODUCT EXISTS ALREADY"


        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


}