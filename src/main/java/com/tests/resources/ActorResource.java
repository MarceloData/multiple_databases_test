package com.tests.resources;

import com.tests.responses.ApiResponse;
import com.tests.services.ActorService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("actors")
public class ActorResource {

    private final ActorService service;

    ActorResource(ActorService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public Response getNumberOfActors() {
        try {
            return Response.ok(new ApiResponse<>(service.actorNumbers())).build();
        } catch (Exception e) {
            return Response.status(null).entity(e.getMessage()).build();
        }
    }
}
