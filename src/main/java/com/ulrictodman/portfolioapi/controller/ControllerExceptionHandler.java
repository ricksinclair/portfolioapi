package com.ulrictodman.portfolioapi.controller;


import com.ulrictodman.portfolioapi.exception.ApiExceptionResponse;
import com.ulrictodman.portfolioapi.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiExceptionResponse response = new ApiExceptionResponse(e.getMessage(),
                e,
                status,
                ZonedDateTime.now(ZoneId.of("EST")));

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class}  )
    public ResponseEntity<Object> handleOtherExceptions(RuntimeException e){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiExceptionResponse response = new ApiExceptionResponse(e.getMessage(), e, status, ZonedDateTime.now(ZoneId.of("EST")));
        return new ResponseEntity<>(response, status);
    }
}
