package RequestPojoTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.Arrays;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import pojo.RequestBody;
public class pojoRequest_Test {
	
	@Test
    public void testCreateUserWithPOJO() {
        // Base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Create UserRequest object
        RequestBody userRequest = new RequestBody();
        userRequest.setName("Reka");
        userRequest.setLanguages(Arrays.asList("java", "python"));

        RequestBody.City city1 = new RequestBody.City();
        city1.setName("pondy");
        city1.setTemperature("30");

        RequestBody.City city2 = new RequestBody.City();
        city2.setName("france");
        city2.setTemperature("40");

        userRequest.setCity(Arrays.asList(city1, city2));

        // Perform POST request using the UserRequest object
        given()
            .contentType(ContentType.JSON)
            .body(userRequest)
        .when()
            .post("/users")
        .then()
            .statusCode(201) // Assuming that 201 is the expected status code for successful creation
            .log().all()
            .body("name", equalTo("Reka"))
            .body("languages", hasItems("java", "python"))
            .body("city", hasItems(hasEntry("name", "pondy"), hasEntry("name", "france")));
    }
}
