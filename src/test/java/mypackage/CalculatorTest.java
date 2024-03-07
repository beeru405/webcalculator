// ----sonar-----
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
        final long result = new Calculator().subFunc(2, 3); // Corrected the method name
        assertThat(result, is(1L));
    }

    @Test
    public void threeXThreeIsNine() throws Exception {
        final long result = new Calculator().mulFucn(3, 3);
        assertThat(result, is(9L));
    }

    @Test
    public void testAdditionAPI() throws Exception {
        // Assuming your API is running at http://localhost:8080/calculator/add
        String apiUrl = "http://192.168.138.114:8081/webapp-0.2/calculator/add?n1=2&n2=3";
        
        // Make an HTTP request to the API
        // Verify that the response status code is 200 (OK)
        // Verify that the response body contains the expected result (5)
        // You might need to use a library like RestAssured for this

        // Example using RestAssured
        int statusCode = io.restassured.RestAssured.get(apiUrl).statusCode();
        assertThat(statusCode, is(200));

        long expectedResult = 5L;
        long actualResult = io.restassured.RestAssured.get(apiUrl).getBody().as(Long.class);
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void testSubtractionAPI() throws Exception {
        // Similar to the testAdditionAPI method, modify the URL for your subtraction API endpoint
    }

    @Test
    public void testMultiplicationAPI() throws Exception {
        // Similar to the testAdditionAPI method, modify the URL for your multiplication API endpoint
    }
}
