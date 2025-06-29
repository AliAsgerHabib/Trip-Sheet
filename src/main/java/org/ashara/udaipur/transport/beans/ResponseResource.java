package org.ashara.udaipur.transport.beans;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonPropertyOrder({"code", "message", "responseTime", "token", "data"})
public class ResponseResource<T> {
    private LocalDateTime responseTime;
    private T data;
    private String message;
    private int code;
    private String token;

    public ResponseResource(HttpStatus status, String message, T data) {
        this.message = message;
        this.data = data;
        this.responseTime = LocalDateTime.now();
        this.token = MDC.get("MDC_TOKEN");
        this.code= status.value();
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
