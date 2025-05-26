package com.tests.exceptions.mappers;

import com.tests.config.CustomLogger;
import com.tests.exceptions.LanguageServiceException;
import com.tests.exceptions.models.ApiErrorResponse;
import com.tests.exceptions.models.TraceIdProvider;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LanguageServiceExceptionMapper implements ExceptionMapper<LanguageServiceException> {

    @Inject
    TraceIdProvider traceIdProvider;

    @Inject
    CustomLogger customLogger;

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(LanguageServiceException ex) {
        ApiErrorResponse response = new ApiErrorResponse(
                500,
                "Service Error",
                ex.getMessage(),
                uriInfo.getPath(),
                traceIdProvider.getTraceId());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(response)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
