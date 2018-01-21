package APIautomation.APIautomation;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import APIautomation.utils.CreatePost;
import io.restassured.http.ContentType;

public class TestPatch {
	
	@Test
	public void TestingPatch()
	{
		CreatePost patch1 = new CreatePost();
		patch1.setTitle("Vai que Vai");
		
		given()
		.contentType(ContentType.JSON)
		.body(patch1)
		.when()
		.patch("http://localhost:3000/posts/1")
		.then()
		.statusCode(200);
	}
}
