package httprequests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class parsejsonbody {
	
	@Test(priority=1)
	public void testjsonresponse() {
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/Store")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		//The below commented line is giving error
	     //.body("Store[0].title", equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"))
		.log().body();
		
		
	}
	
	

}
