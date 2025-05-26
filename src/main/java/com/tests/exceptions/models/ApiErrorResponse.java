package com.tests.exceptions.models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiErrorResponse {

    public String timestamp;
    public int status;
    public String error;
    public String message;
    public String path;
    public String traceId;

    public ApiErrorResponse(int status, String error, String message, String path, String traceId) {
        this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.traceId = traceId;
    }
}
