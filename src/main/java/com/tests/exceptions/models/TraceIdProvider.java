package com.tests.exceptions.models;

import java.util.UUID;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TraceIdProvider {

    private final String traceId = UUID.randomUUID().toString().replace("-", "");

    public String getTraceId() {
        return traceId;
    }
}
