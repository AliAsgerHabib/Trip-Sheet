package org.ashara.udaipur.transport.exceptions;

public class ActCommonException extends RuntimeException{

    private String msg;

    public ActCommonException() {}

    public ActCommonException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
