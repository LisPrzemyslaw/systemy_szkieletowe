package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class ReservationTest {
    @Test
    void testStatusCode() {
        given()
                .when().get("/reservation")
                .then()
                .statusCode(200)
                .body(containsString("<h1>Table reservation in restaurant</h1>"));
    }

    @Test
    void testReservation() {
        LocalDate date = LocalDate.now();
        String time = "10:00";
        given()
                .when().get("/reservation/1?date=" + date + "&time=" + time)
                .then()
                .body("availableTables", equalTo(4));
    }

}