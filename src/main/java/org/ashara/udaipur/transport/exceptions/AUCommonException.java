package org.ashara.udaipur.transport.exceptions;

public class AUCommonException extends RuntimeException{

    private String message;

    public AUCommonException() {}

    public AUCommonException(String msg) {
        super(msg);
        this.message = msg;
    }
}
