package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/table")
public class TableApi {

    @GET
    @Path("/{tableId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String index(@PathParam("tableId") Long tableId) {
        return "table number: " + tableId.toString();
    }
}
