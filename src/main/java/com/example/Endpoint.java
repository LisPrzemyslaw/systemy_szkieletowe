package com.example;

import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class Endpoint {
    @Inject
    Template endpoint;

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_HTML)

    public String index() {
        return this.endpoint.render();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddUserToDatabase(RestaurantUser user) {
        TypedQuery<RestaurantUser> query = entityManager.createQuery(
                "SELECT u FROM restaurant_user u WHERE u.username = :username", RestaurantUser.class);
        query.setParameter("username", user.getUsername());
        try {
            query.getSingleResult();
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (NoResultException e) {
            entityManager.persist(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
        }
    }
}
