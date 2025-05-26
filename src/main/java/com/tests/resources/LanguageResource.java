package com.tests.resources;

import java.util.List;

import com.tests.dtos.LanguageDTO;
import com.tests.responses.ApiResponse;
import com.tests.services.LanguageService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("language")
public class LanguageResource {

    @Inject
    LanguageService languageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response listLanguages() {
        List<LanguageDTO> languages = languageService.listLanguages();
        return Response.ok(new ApiResponse<>(languages)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public Response countLanguages() {
        Long count = languageService.countLanguages();
        return Response.ok(new ApiResponse<>(count)).build();
    }
}
