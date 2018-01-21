package APIautomation.APIautomation;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import APIautomation.utils.CreatePost;
import static org.assertj.core.api.Assertions.*;

public class TestPUT {

	@Test
	public void TestUpdate()
	{
		CreatePost put1 = new CreatePost();
		put1.setId(5);
		put1.setTitle("Macarronada da hora");
		put1.setAuthor("Daiane Macedo");
		
		given()
		.contentType(ContentType.JSON)
		.body(put1)
		.when()
		.put("http://localhost:3000/posts/5")
		.then()
		.statusCode(200)
		// assertion json path using hamcrest
		.body("title", is("Macarronada da hora"))
		.body("author", is("Daiane Macedo"));
		
		
		ValidatableResponse vr = given()
		.contentType(ContentType.JSON)
		.body(put1)
		.when()
		.put("http://localhost:3000/posts/5")
		.then()
		.statusCode(200);
		
		// Assertion json path using Assert junit
		String title = vr.extract().path("title");
		System.out.println(title);
		Assert.assertEquals(title, "Macarronada da hora");
		
		
		
	}
	

}
