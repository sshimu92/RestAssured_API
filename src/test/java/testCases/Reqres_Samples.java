package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.HashMap;

public class Reqres_Samples {

	@Test(priority = 1)
	public void get_Method() {
		
		  given()
		  
		  .when()
		       .get("https://reqres.in/api/users?page=2")
		       
		  .then()
		        .statusCode(200);
		
	}
	
	@Test(priority = 2)
	public void post_Method() {
		
		HashMap data = new HashMap();
		data.put("id", "731");
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		Response res = 
		
		given()
		     .contentType("application/json")
		     .body(data)
		
		.when()
		      .post("https://reqres.in/api/users")
		      
		.then()
		      .statusCode(201)
		      .log().body()
		      .extract().response();
		
		
		int verifyCode = res.statusCode();
		
		Assert.assertEquals(verifyCode, 201);
		
	}

	@Test(priority = 3)
	public void Put_Method() {
		
		HashMap data = new HashMap();
		data.put("name", "Mike");
		data.put("id", "831");
		data.put("job", "Teacher");
		
		Response res = 
	
		given()
		      .contentType("application/json")
		      .body(data)
		      
		.when()
		      .put("https://reqres.in/api/users/2")
		      
		 .then()
		       .statusCode(200)
		       .log().body()
		       .extract().response();
		
		String jsonString = res.toString();
		
		Assert.assertEquals(jsonString.contains("Response"), true);
	}

	@Test(priority = 4)
	public void delete_Method() {
		
		given()
		
		.when()
		      .delete("https://reqres.in/api/users/2")
		
		.then()
		      .statusCode(204)
		      .log().body()
		      .extract().response();
		
	}


}
