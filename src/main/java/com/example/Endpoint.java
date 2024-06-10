package com.example;

import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
/*
-- CREATE TABLE reservation (
--                              id SERIAL PRIMARY KEY,
--                              table_id BIGINT NOT NULL,
--                              user_id BIGINT NOT NULL,
--                              date DATE NOT NULL,
--                              time TIME NOT NULL
-- );
-- CREATE TABLE restaurant (
--                             id SERIAL PRIMARY KEY
-- );
-- CREATE TABLE "user" (
--                        id SERIAL PRIMARY KEY,
--                        username VARCHAR(255) NOT NULL UNIQUE,
--                        first_name VARCHAR(255) NOT NULL,
--                        last_name VARCHAR(255) NOT NULL
-- );
-- CREATE TABLE "table" (
--                        id SERIAL PRIMARY KEY,
--                        chairs INT NOT NULL,
--                        is_reserved BOOLEAN NOT NULL,
--                        restaurant_id BIGINT NOT NULL,
--                        user_id BIGINT,
--                        reservation_id BIGINT,
--                        CONSTRAINT fk_restaurant
--                            FOREIGN KEY (restaurant_id)
--                                REFERENCES restaurant(id),
--                        CONSTRAINT fk_user
--                            FOREIGN KEY (user_id)
--                                REFERENCES "user"(id),
--                        CONSTRAINT fk_reservation
--                            FOREIGN KEY (reservation_id)
--                                REFERENCES reservation(id)
-- );

 */
@Path("/")
public class Endpoint {
    @Inject
    Template endpoint;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return this.endpoint.render();
    }
}
