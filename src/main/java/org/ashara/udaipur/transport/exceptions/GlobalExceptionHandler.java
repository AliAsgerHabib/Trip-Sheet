package org.ashara.udaipur.transport.exceptions;


import org.ashara.udaipur.transport.beans.ResponseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResource<String> handleException(Exception ex) {
        logger.error("Exception occurred:", ex);
        return new ResponseResource<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseResource<String> handleMethodArgumentException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        logger.error("Exception occurred: {}", errors, ex);
        return new ResponseResource<>(HttpStatus.BAD_REQUEST, errors.toString(), null);
    }


    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseResource<String> handleResourceNotFound(ResourceNotFoundException ex) {
        logger.error("Exception occurred: {}", ex);
        return new ResponseResource<>(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }
}