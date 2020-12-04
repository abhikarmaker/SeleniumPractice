import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET {
	@Test //Now this is a TestNG Test
	void test_01() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");// We can use the https methods such as post, get, patch, options
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		
	}
}
