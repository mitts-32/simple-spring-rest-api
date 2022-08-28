package com.juniordevmind.simplespringrestapi.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<?> handleNotFoundException(RuntimeException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return this.handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(value = { BadRequestException.class })
    protected ResponseEntity<?> handleBadRequestException(RuntimeException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return this.handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST,
                request);
    }
}
