package mypackage;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    
    @Test
    public void twoAndThreeIsFive() throws Exception {
        final long result = new Calculator().addFucn(2, 3);
        assertThat(result, is(5L));
    }

    @Test
    public void threeMinusTwoIsOne() throws Exception {
        final long result = new Calculator().subFunc(2, 3);
        assertThat(result, is(1L));
    }

    @Test
    public void threeXThreeIsNine() throws Exception {
        final long result = new Calculator().mulFucn(3, 3);
        assertThat(result, is(9L));
    }

    @Test
    public void testAdditionAPI() throws Exception {
        // Replace this URL with the correct endpoint for your addition API
        String apiUrl = "http://192.168.138.114:8081/webapp-0.2/calculator/add?n1=2&n2=3";

        // Make an HTTP request to the API
        int statusCode = io.restassured.RestAssured.get(apiUrl).statusCode();

        // Verify that the response status code is 200 (OK)
        assertThat(statusCode, is(200));

        // Verify that the response body contains the expected result (5)
        long expectedResult = 5L;
        long actualResult = io.restassured.RestAssured.get(apiUrl).getBody().as(Long.class);
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void testSubtractionAPI() throws Exception {
        // Replace this URL with the correct endpoint for your subtraction API
        String apiUrl = "http://192.168.138.114:8081/webapp-0.2/calculator/subtract?n1=5&n2=3";

        // Make an HTTP request to the API
        int statusCode = io.restassured.RestAssured.get(apiUrl).statusCode();

        // Verify that the response status code is 200 (OK)
        assertThat(statusCode, is(200));

        // Verify that the response body contains the expected result (2)
        long expectedResult = 2L;
        long actualResult = io.restassured.RestAssured.get(apiUrl).getBody().as(Long.class);
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void testMultiplicationAPI() throws Exception {
        // Replace this URL with the correct endpoint for your multiplication API
        String apiUrl = "http://192.168.138.114:8081/webapp-0.2/calculator/multiply?n1=3&n2=4";

        // Make an HTTP request to the API
        int statusCode = io.restassured.RestAssured.get(apiUrl).statusCode();

        // Verify that the response status code is 200 (OK)
        assertThat(statusCode, is(200));

        // Verify that the response body contains the expected result (12)
        long expectedResult = 12L;
        long actualResult = io.restassured.RestAssured.get(apiUrl).getBody().as(Long.class);
        assertThat(actualResult, is(expectedResult));
    }
}
