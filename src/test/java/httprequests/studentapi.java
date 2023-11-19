package httprequests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class studentapi {
	
//	@Test(priority=1)
	public void UseHasMap() {
	
	HashMap<String, String> HMapObj = new HashMap<String, String>();	
	HMapObj.put("email","tetanda.taibu@gmail.com");	
	HMapObj.put("first_name","Tetanda");
	HMapObj.put("last_name","Taibu");
	HMapObj.put("grade","A");
	
	given()
	.contentType("application/json")
	.body(HMapObj)
	
	.when()
	 .post("http://localhost:3000/students")
	 
	 .then()
	 .statusCode(201)
	 .body("email",equalTo("tetanda.taibu@gmail.com"))
	 .body("first_name",equalTo("Tetanda"))
	 .body("last_name",equalTo("Taibu"))
	 .body("grade",equalTo("A"))
	 .header("Content-Type","application/json; charset=utf-8")
	 .log().all();
	
	}
	
//	@Test(priority=2)
	public void jsonobj() {
		
		JSONObject jdata = new JSONObject();
		jdata.put("email","mark.waugh@gmail.com");
		jdata.put("first_name", "Mark");
		jdata.put("last_name", "Waugh");
		jdata.put("grade","A+");
		
		given()
		.contentType("application/json")
		.body(jdata.toString())
		
		.when()
		  .post("http://localhost:3000/students")
		  
		.then()
		 .statusCode(201)
		 .body("email",equalTo("mark.waugh@gmail.com"))
		 .body("first_name",equalTo("Mark"))
		 .body("last_name",equalTo("Waugh"))
		 .body("grade",equalTo("A+"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
		
		
	}

	 @Test(priority=3)
    public void pojoimplementation() {
    	
    	pojoclass pobj = new pojoclass();
    	pobj.setEmail("steven.waugh@gmail.com");
    	pobj.setFirst_name("Steven");
    	pobj.setLast_name("Waugh");
    	pobj.setGrade("A+");
    	
		given()
		.contentType("application/json")
		.body(pobj)
		
		.when()
		  .post("http://localhost:3000/students")
		  
		.then()
		 .statusCode(201)
		 .body("email",equalTo("steven.waugh@gmail.com"))
		 .body("first_name",equalTo("Steven"))
		 .body("last_name",equalTo("Waugh"))
		 .body("grade",equalTo("A+"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
		
    	
    	
    }
	
	 @Test(priority=4)
	    public void extjsonfile() throws FileNotFoundException {
		 
		 File f = new File(".\\body.json");		 
		 FileReader fr = new FileReader(f);
		 JSONTokener jt = new JSONTokener(fr);
		 JSONObject data = new JSONObject(jt);
		 
			given()
			.contentType("application/json")
			.body(data.toString())
			
			  .post("http://localhost:3000/students")
			  
			.then()
			 .statusCode(201)
			 .body("email",equalTo("jeff.dare@reqres.in"))
			 .body("first_name",equalTo("Jeff"))
			 .body("last_name",equalTo("Dare"))
			 .body("grade",equalTo("A+"))
			 .header("Content-Type","application/json; charset=utf-8")
			 .log().all();
			
	    	
	    	
	    }
	 
}
		 
		 
		 
		 
		 


