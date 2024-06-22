package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class EndpointTest {

    @Test
    void testStatusCode() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(containsString("<h1>Table reservation in restaurant</h1>"));
    }
}
