package com.tests.resources;

import com.tests.responses.ApiResponse;
import com.tests.services.CategoryService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categories")
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public Response countCategories() {
        try {
            return Response.ok(new ApiResponse<>(categoryService.countCategories())).build();
        } catch (Exception e) {
            return Response.status(0).entity(e.getMessage()).build();
        }
    }
}
