package APIautomation.APIautomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assert.*;

public class TesteAPI {

	@org.junit.Test
	public void teste1() {
		// import not static
		//Response response = RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN");
		
		// import statc
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
	
	public void validateStatus(int status, Response teste)
	{
		Assert.assertEquals(teste.getStatusCode(), status);
	}
}



//
// http://services.groupkt.com/country/get/all
// http://services.groupkt.com/country/get/iso2code/IN
// http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/
// http://www.thomas-bayer.com/sqlrest/CUSTOMER/
//http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json
// {
// "RestResponse" : {
// "messages" : [ "Country found matching code [IN]." ],
// "result" : {
// "name" : "India",
// "alpha2_code" : "IN",
// "alpha3_code" : "IND"
// }
// }
// }
