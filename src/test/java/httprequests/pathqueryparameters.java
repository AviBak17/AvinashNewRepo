package httprequests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class pathqueryparameters {
	
	@Test(priority=1)
	public void pathqueryparameters() {
		
		 given()
		 .pathParam("mypath", "users")
		 .queryParam("page",2)
		 .queryParam("id",5)
		 
		.when()
	     .get("https://reqres.in/api/{mypath}")
	     
	     .then()
	     .statusCode(200)
	     .log().body();
	     
  		
		
	}
	
	@Test(priority=2)
	public void getcookieinfo() {
		
		
	Response Res = given()
		
		.when()
		.get("https://www.google.com");
	
	String cookie_value = Res.getCookie("AEC");
	
	System.out.println("Cookie Value =====>>>> " + cookie_value);
		
	
		
	}
	
	
	@Test(priority=3)
	public void getcookiesinfo() {
		
		
	Response Res = given()
		
		.when()
		.get("https://www.google.com");
	
	 Map<String,String> cookies_values = Res.getCookies();
	
	 for(String k : cookies_values.keySet()) {
		
	     String CookiName =Res.getCookie(k);
	
	     System.out.println(k + "   " + CookiName );
	 	
	}
		
	}
	
	@Test(priority=4)
	public void testheaders() {
		
		given()
		
		.when()
		.get("https://www.google.com")
		
		.then()
		.statusCode(200)
		.and()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("Server", "gws");
		
		
	}
	
	
	@Test(priority=5)
	public void testallheaders() {
		

		Response Res = given()
				              
		                          .when()
		                          .get("https://www.google.com");
		                          
		
	  Headers AllHeaders	= Res.getHeaders();
	  
	   for(Header hd : AllHeaders ) {
		  	   
		 System.out.println(hd.getName() + "    " + hd.getValue()); 
		   
	   }
		
		 
	}
	
	
	
}
