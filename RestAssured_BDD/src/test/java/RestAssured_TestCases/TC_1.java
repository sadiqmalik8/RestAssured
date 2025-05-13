package RestAssured_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TC_1 {
	static String baseURI= "https://api.restful-api.dev/";
	
	
	@Test
	public static void GetMethod() {
		
//		Map<String, String> headers = new HashMap<>();
//		headers.put("X-API-Key", "reqres-free-v1");
		
		Response response= get(baseURI +"objects");
		
		 //System.out.println(response.statusCode());
		 //System.out.println(response.time());
		 //System.out.println(response.asPrettyString());
		 //System.out.println(response.statusLine());
		  
		                  // Hard Asserts//
//		Assert.assertEquals(response.statusCode(), 201);
//		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		
		
		                 //Soft asserts//
		SoftAssert SAssert= new SoftAssert();
		
		SAssert.assertEquals(response.statusCode(), 200);
		SAssert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	
	}
	
	
	
	@Test(groups= {"Regression"})
	public static void GetMethodwithBDD() {
		
		given()
		 .get(baseURI+ "objects")
		 
		 .then()
		 .statusCode(200).log().all()
		 .body("[3].name", equalTo("Apple iPhone 11, 64GB"))
		 //.body("[6].data.CPU model", equalTo("Intel Core i9"))
		 //.body("data.capacity GB", hasItem(512))
		.body("name", hasItems("Apple iPad Mini 5th Gen","Samsung Galaxy Z Fold2"));    //hasitem use to find one string amongs collection of strings
	}

	@Test(groups= {"Regression","Smoke"})
	public static void PostMethod() {
		
		JSONObject payload = new JSONObject();
		
		payload.put("name", "aadil");
		payload.put("mobile", "oppo reno 13");
		payload.put("address", "ghaziabad");
		
		System.out.println(payload);
		
		
		given()
		//.header("Cntent type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(payload.toJSONString())
		
		.when()
		.post(baseURI+ "objects")
		
		.then().log().all();
		
		
		
		
		
		
		

		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
