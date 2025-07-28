package de.turing85.quarkus.camel.identifier;

import jakarta.ws.rs.core.Response;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

@QuarkusTest
class GreeterRouteTest {
  @Test
  void get() {
    // @formatter:off
    RestAssured
        .when().get(GreeterRoute.HTTP_PATH)

        .then()
            .statusCode(Response.Status.OK.getStatusCode())
            .body(is("Hello"));
    // @formatter:on
  }
}
