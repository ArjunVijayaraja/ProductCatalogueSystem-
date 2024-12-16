package com.example.productCatalogSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String errorCode;

//    public ErrorDetails(LocalDateTime timeStamp, String message, String path, String errCode){
//        this.timeStamp = timeStamp;
//        this.message = message;
//        this.path   = path;
//        this.errorCode = errCode;
//    }
//
//    public ErrorDetails(){
//
//    }
}
