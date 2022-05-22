package com.quarkus.saga.rafamrqs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello1")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}