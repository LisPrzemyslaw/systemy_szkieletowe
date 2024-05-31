package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class UserApi {

    @GET
    @Path("/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String userInfo(@PathParam("username") String username) {
        return "Hello" + username + "!";
    }

}
