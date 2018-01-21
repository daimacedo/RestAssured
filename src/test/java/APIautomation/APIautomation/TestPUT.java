package APIautomation.APIautomation;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import APIautomation.utils.CreatePost;

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
		.body("title", is("Macarronada da hora"))
		.body("author", is("Daiane Macedo"));
		
	}
	

}
