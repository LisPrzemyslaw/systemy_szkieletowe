package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class TableTest {

    @Test
    void testStatusCode() {
        String tableId = "1";
        given()
                .when().get("/table/" + tableId)
                .then()
                .statusCode(200)
                .body(containsString("table number: " + tableId));
    }
}
