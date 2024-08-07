package testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class GetAndPostExamples {

	@Test
	public void test_Get() {
		
		baseURI = "https://reqres.in/api";
		
		given()
		   .get("/users?page=2")
		
		.then()
		   .statusCode(200)
		   .body("data[4].first_name", equalTo("George"))
		   .body("data.first_name", hasItems("George", "Rachel"));
	
	}
	
	@Test
	public void test_Post() {
		
		HashMap data = new HashMap();
//		data.put("name", "David");
//		data.put("job", "Teacher");
		
		JSONObject request = new JSONObject(data);
		request.put("name", "David");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given()
		     .contentType("application/json")
		     .accept(ContentType.JSON)
		     .body(request.toJSONString())
		
		.when()
             .post("/users")
             
        .then()
             .statusCode(201)
             .log().all();
		
	}
}
