package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class Endpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Main screen";
    }
}
