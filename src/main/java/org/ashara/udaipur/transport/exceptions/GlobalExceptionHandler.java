package org.ashara.udaipur.transport.exceptions;


import org.ashara.udaipur.transport.beans.ResponseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResource<String> handleException(Exception ex) {
        logger.error("Exception occured:", ex);
        return new ResponseResource<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
    }
}