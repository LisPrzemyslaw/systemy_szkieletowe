package com.example;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
@QuarkusTest
public class UserTest {
    @Test
    void testStatusCode() {
        String username = "sample_user";
        given()
                .when().get("/user/" + username)
                .then()
                .statusCode(200)
                .body(containsString("Hello" + username + "!"));
    }
}
