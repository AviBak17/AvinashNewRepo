package httprequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class httprequests {
	
	@Test(priority=1)
	public void getUser() {
		
		  given()
		 
		 .when()
		 .get("https://reqres.in/api/users?page=2")
		 
		 .then()
		 .statusCode(200)
		 .body("page", equalTo(2))
         .log().all();   
   		 
		
	}
	
	@Test(priority=2)
	public void createUser() {
		
		HashMap<String,String> data = new HashMap<String,String>();
		
		data.put("Name", "Pavan");
		data.put("Job","Trainer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all();
				
	}
	
	@Test(priority=3,dependsOnMethods = ("createUser"))
	public void updateUser() {
		
		HashMap<String,String> data = new HashMap<String,String>();
		
		data.put("Name", "Shamanth");
		data.put("Job","Guide");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all();
		
		
		
	}
	@Test(priority=4)
	public void deleteUser() {
		

	    when()
		.delete("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(204)
		.log().all();
		
			
	}
	
}
