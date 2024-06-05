package com.example;

import io.vertx.core.json.Json;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.qute.Template;
import io.quarkus.qute.Engine;

import java.util.ArrayList;
import java.util.List;

@Path("/reservation")
public class ReservationApi {
    @Inject
    Template reservation;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        List<String> restaurants = new ArrayList<>();
        restaurants.add("KFC");
        restaurants.add("MCDonald");


        return this.reservation.data("restaurants", restaurants)
                .data("tableNumber", 4).render();
    }
}
