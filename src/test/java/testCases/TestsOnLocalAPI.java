package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class TestsOnLocalAPI {

	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given()
		     .get("/users")
		
		.then()
		      .statusCode(200)
		      .log().all();
		
		
	}
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "David");
		request.put("lastName", "Spade");
		request.put("subjectId", 2);
		request.put("id", 5);
		
        baseURI = "http://localhost:3000";
		
		given()
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(request.toJSONString())
		
	    .when()
	         .post("/users")
	         
	    .then()
	         .statusCode(201)
	         .log().all();
		
	}
//     @Test 
//     public void put() {
//		
//		JSONObject request = new JSONObject();
//		
//		request.put("firstName", "Albert");
//		request.put("lastName", "Einstein");
//		request.put("subjectId", 2);
//		
//		
//		
//        baseURI = "http://localhost:3000";
//		
//		given()
//		     .header("Content-Type", "application/json")
//		     .body(request.toJSONString())
//		
//	    .when()
//	         .put("/users/5")
//	         
//	    .then()
//	         .statusCode(200)
//	         .log().all();
//		
//	}


}
