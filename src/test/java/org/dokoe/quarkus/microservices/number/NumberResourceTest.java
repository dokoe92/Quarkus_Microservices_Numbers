package org.dokoe.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static groovy.xml.Entity.not;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/numbers")
                .then()
                .statusCode(200)
                .body("isbn_13", startsWith("13-"))
                .body("isbn_10", startsWith("10-"))
                .body(CoreMatchers.not(Matchers.hasKey("generationDate")));
    }

}