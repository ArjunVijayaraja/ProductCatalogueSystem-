package com.example.productCatalogSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistException  extends RuntimeException{

    public ProductAlreadyExistException(String prodName){
        super(String.format("The item: '%s' already exists",prodName));

    }

}
