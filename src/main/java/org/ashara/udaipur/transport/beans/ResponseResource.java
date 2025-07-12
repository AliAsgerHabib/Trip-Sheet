package org.ashara.udaipur.transport.beans;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonPropertyOrder({"code", "message", "responseTime", "token", "data"})
@Getter
@Setter
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
}
