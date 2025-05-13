package RestAssured_TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class LocalApi {

	String baseURI= "http://localhost:3000/";
	
	@Test
	public void LocalGet() {
		given()
		.get(baseURI+ "users")
		
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void LocalPost() {
		
		JSONObject payload = new JSONObject();
		payload.put("name", "sadiq");
		payload.put("username", "sadiqmalik8");
		payload.put("address", "muradnagar");
		payload.put("contact", "9045623101");
		
		
		given().body(payload.toJSONString())
		
		.when()
		.post(baseURI+ "users")
		
		.then().statusCode(201);
	
	}
	
	
	@Test
	public void LocalPut() {
		
		JSONObject payload = new JSONObject();
		payload.put("name", "sadiq");
		payload.put("username", "sadiqmalik8");
		payload.put("address", "jaipur");
		payload.put("contact", "9319621703");
		
		
		given().body(payload)
		
		.when()
		.put(baseURI+ "users/da8f")
		
		.then().statusCode(200);
	
	}
	
	
	
	@Test
	public void LocalPatch() {
		
		JSONObject payload = new JSONObject();
		//payload.put("name", "sadiq");
		//payload.put("username", "sadiqmalik8");
		payload.put("address", "ghaziabad");
		//payload.put("contact", "9319621703");
		
		
		given().body(payload)
		
		.when()
		.patch(baseURI+ "users/ba34")
		
		.then().statusCode(200);
	
	}
	
	
	@Test
    public void LocalDelete() {
		
		//JSONObject payload = new JSONObject();
		//payload.put("name", "sadiq");
		//payload.put("username", "sadiqmalik8");
		//payload.put("address", "ghaziabad");
		//payload.put("contact", "9319621703");
		
		
		given()
		//.body(payload)
		
		.when()
		.delete(baseURI+ "users/da8f")
		
		.then().statusCode(200);
	
	}
	
	
	
	
	

}
