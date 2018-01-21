package APIautomation.APIautomation;
import static io.restassured.RestAssured.*;

import org.junit.Test;

public class TestDELETE {

	
	@Test
	public void TestingDelete()
	{
		when()
		.delete("http://localhost:3000/posts/1")
		.then()
		.statusCode(200);
	}
}
