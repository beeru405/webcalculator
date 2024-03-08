package mypackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorAPITest {
    private static final String BASE_URL = "http://192.168.138.114:8081/webapp-0.2";

    @Test
    public void testAdditionAPI() {
        given()
            .param("n1", 5)
            .param("n2", 10)
        .when()
            .get(BASE_URL + "/add")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("result", equalTo(15));
    }

    @Test
    public void testSubtractionAPI() {
        given()
            .param("n1", 10)
            .param("n2", 5)
        .when()
            .get(BASE_URL + "/subtract")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("result", equalTo(5));
    }

    @Test
    public void testMultiplicationAPI() {
        // Add a similar test for multiplication
    }

    @Test
    public void testDivisionAPI() {
        // Add a similar test for division
    }
}
