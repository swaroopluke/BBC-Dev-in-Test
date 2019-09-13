package commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

	ConfigFileReader configFileReader;
	RequestSpecification request;
	Response response;
	JsonPath jsonPath;

	public void setBaseURI() {
		configFileReader = new ConfigFileReader();
		RestAssured.baseURI = configFileReader.getURI();
	}

	public RequestSpecification getRequest() {
		RequestSpecification request = RestAssured.given();
		return request;
	}

	public JsonPath getResponseJsonPath(Response res) {
		String json = res.asString();
		return new JsonPath(json);
	}

	public String getDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date date = cal.getTime();
		String modifiedDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
		return modifiedDate;
	}

	public String getLocationId(String locationName) {
		setBaseURI();
		request = getRequest();
		response = request.get(configFileReader.getURI() + Resources.locationResource(locationName));
		JsonPath jsonPath = response.jsonPath();
		return jsonPath.get("[0].woeid").toString();
	}
}
