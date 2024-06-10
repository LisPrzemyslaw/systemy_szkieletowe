package com.example;

import io.vertx.core.json.Json;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.qute.Template;
import io.quarkus.qute.Engine;

import java.util.ArrayList;
import java.util.List;

@Path("/reservation")
public class ReservationApi {
    @Inject
    Template reservation;

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        TypedQuery<Restaurant> queryGetAllRestaurant = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
        List<Restaurant> restaurants = queryGetAllRestaurant.getResultList();

        return this.reservation.data("restaurants", restaurants).render();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurant getRestaurantById(@PathParam("id") Long id,
                                        @QueryParam("date") String date,
                                        @QueryParam("time") String time) {
        Restaurant restaurant = entityManager.find(Restaurant.class, id);
        if (restaurant == null) throw new NotFoundException("Restaurant not found with id " + id);


        return restaurant;
    }

    @POST
    @Transactional
    public void createReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }
}
