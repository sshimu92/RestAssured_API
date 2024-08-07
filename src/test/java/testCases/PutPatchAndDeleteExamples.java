package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;


public class PutPatchAndDeleteExamples {

	@Test
    public void test_Put() {
		
		JSONObject request = new JSONObject();
		request.put("name", "David");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		Response response =
		
		given()
		     .contentType("application/json")
		     .body(request)
		
		.when()
             .put("/users/2")
             
        .then()
             .statusCode(200)
             .log().body()
             .extract().response();
		
		response.then()
		            .body("name", equalTo("David"));
		
		String jsonString = response.body().asString();
		
		Assert.assertEquals(jsonString, jsonString);
		            
		
	}
	 @Test
     public void test_Patch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "David");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given()
		     .contentType("application/json")
		     .accept(ContentType.JSON)
		     .body(request.toJSONString())
		
		.when()
             .patch("/api/users/2")
             
        .then()
             .statusCode(200)
             .log().all();
		
	}
     @Test
	 public void test_Delete() {
			
			baseURI = "https://reqres.in";
			
			given()
			    
			.when()
	             .delete("/api/users/2")
	             
	        .then()
	             .statusCode(204)
	             .log().all();
			
		}
 
}
