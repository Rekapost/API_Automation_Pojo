package RequestPojoTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import pojo.RequestBody;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class NormalRequestTest {
	String baseUrl = "https://reqres.in/api";
	  
	@Test(description =" Test Post Request")  
	 public void testPostMethod() 
	{
	        // Base URI
	        RestAssured.baseURI = "https://reqres.in/api";

	        // Request Body
	        Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("name", "Reka");

	        List<String> languages = Arrays.asList("java", "python");
	        requestBody.put("languages", languages);

	        List<Map<String, Object>> cities = Arrays.asList(
	                Map.of("name", "pondy", "temperature", "30"),
	                Map.of("name", "france", "temperature", "40")
	        );
	        requestBody.put("city", cities);

	        // Perform POST request
	        given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	        .when()
	            .post("/users")
	        .then()
	            .statusCode(201) // Assuming that 201 is the expected status code for successful creation
	            .body("name", equalTo("Reka"))
	            .body("languages", hasItems("java", "python"))
	            .body("city", hasItems(hasEntry("name", "pondy"), hasEntry("name", "france")))
	            .log().all();
	    }
}
