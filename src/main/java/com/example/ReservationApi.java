package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.qute.Template;
import io.quarkus.qute.Engine;

@Path("/reservation")
public class ReservationApi {
    @Inject
    Engine engine;

    @Inject
    Template resevation = engine.parse("reservation.html");



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "";
    }
}
