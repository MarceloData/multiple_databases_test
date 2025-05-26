package com.tests.exceptions.mappers;

import com.tests.config.CustomLogger;
import com.tests.exceptions.models.ApiErrorResponse;
import com.tests.exceptions.models.TraceIdProvider;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Inject
    TraceIdProvider traceIdProvider;

    @Inject
    CustomLogger logger;

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(NotFoundException ex) {
        logger.warn("Resource not found");
        ApiErrorResponse response = new ApiErrorResponse(
                404,
                "Resource not found",
                ex.getMessage(),
                uriInfo.getPath(),
                traceIdProvider.getTraceId());
        return Response.status(Response.Status.NOT_FOUND).entity(response).type(MediaType.APPLICATION_JSON).build();
    }
}