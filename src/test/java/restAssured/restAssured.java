package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sun.nio.cs.Surrogate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class restAssured {
    @Test
    public void testGetUserWithHeadersAndAssertions() {
        // Set base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request with content type and headers, then extract response
        Response response = given()
                .contentType(ContentType.JSON)   // Set content type
                .header("Custom-Header", "value") // Example header
                .log().all()                      // Log request
                .when()
                .get("/users/1")
                .then()
                .log().all()                      // Log response
                .statusCode(200)                  // Assert status code
                .extract()
                .response();                      // Extract full response
        //Hamcrest Methods
        // Validate response fields using assertions
        assertThat(response.getStatusCode(), equalTo(200));
        //assertThat(String.valueOf(response.jsonPath().getInt("id")), Surrogate.is(1));
        assertThat(response.jsonPath().getString("username"), notNullValue());
    }
}

