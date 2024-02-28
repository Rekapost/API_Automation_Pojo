package pojo;
import java.util.List;
import java.util.Map;

public class RequestBody {
	// Assuming your API endpoint is "https://example.com/api"
	    String baseUrl = "https://reqres.in/api";
	    private String name;
	    private List<String> languages;
	    private List<City> city;

	    // Constructors, getters, and setters

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<String> getLanguages() {
	        return languages;
	    }

	    public void setLanguages(List<String> languages) {
	        this.languages = languages;
	    }

	    public List<City> getCity() {
	        return city;
	    }

	    public void setCity(List<City> city) {
	        this.city = city;
	    }

	    // City class to represent the city object within the request body
	    public static class City {
	        private String name;
	        private String temperature;

	        // Constructors, getters, and setters

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public String getTemperature() {
	            return temperature;
	        }

	        public void setTemperature(String temperature) {
	            this.temperature = temperature;
	        }
	    }
	}
	
	
/* create a test script with rest assured for below :
	Method: POST
	URI: https://reqres.in/api/users
	Requestbody using pojo class
	Request Body:
	{
		"name": "Reka",
		"languages":["java","python"],
		"city":[
		        {
			    "name":"pondy",
			    "temperature":"30"
		        }
		        {
		      	"name":"france",
			    "temperature":"40"  	
		        }
		        ]
	 }
*/	
