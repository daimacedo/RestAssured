package APIautomation.APIautomation;

import APIautomation.utils.CreatePost;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class TesteAPI {

	@org.junit.Test
	public void getResponse() {
		// import not static
		// Response response =
		// RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN");

		// import static
		Response response = get("http://services.groupkt.com/country/get/iso2code/IN");

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getContentType());

		// Assert using junit
		Assert.assertEquals(response.getContentType().contains("json"), true);
		// Assert using assert-j
		assertThat(response.getContentType()).contains("json");
		// validação incapsulada
		validateStatus(200, response);

	}

	@org.junit.Test
	public void setParameters() {
		// If you have to pass some parameters to a URI, u can send like this:
		// Given has everything i have to pass before to send a GET request to
		// the API
		// in this case i have to pass the parameters
		String uri = "https://postman-echo.com/get";

		// If i dont use this method, my uri https will return connection refuse
		RestAssured.useRelaxedHTTPSValidation();
		Response r = RestAssured.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
		System.out.println(r.asString());

		given().param("foo1", "bar1").param("foo2", "bar2").when().get(uri).then().statusCode(200);

	}

	@org.junit.Test
	public void postTestAPI() {
		given().contentType(ContentType.JSON)
				.body(" {\"id\": 2, \"title\": \"json-server\", \"author\": \"typicode\" }").when()
				.post("http://localhost:3000/posts").then().contentType(ContentType.JSON).statusCode(201);

	}

	public void validateStatus(int status, Response teste) {
		Assert.assertEquals(teste.getStatusCode(), status);
	}

	@org.junit.Test
	public void postTestWithJsonObject() {
		CreatePost body = new CreatePost();
		body.setId(1);
		body.setTitle("Os homens que nao amavama as mulhres");
		body.setAuthor("Teste");

		System.out.println(body.toString());

		given().contentType(ContentType.JSON).body(body).when().post("http://localhost:3000/posts").then()
				.statusCode(201).contentType(ContentType.JSON)
				// to use a body validation u need to import static hamcrest, i
				// u dont it wont work
				.body("title", equalTo("Os homens que nao amavama as mulhres"));

	}
}
