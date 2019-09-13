package stepDefinitions;

import org.hamcrest.Matchers;
import org.junit.Assert;
import commons.Base;
import commons.ConfigFileReader;
import commons.Resources;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class WeatherStepDefs extends Base {

	RequestSpecification request;
	Response response;
	ConfigFileReader configFileReader;
	JsonPath jsonPath;
	String actualWeatherStateName;
	String actualWeatherStateAbbr;

	public WeatherStepDefs() {
		configFileReader = new ConfigFileReader();
	}

	@Given("^the user is about to make a request to the endpoint$")
	public void the_user_is_about_to_make_a_request_to_the_endpoint() throws Throwable {
		setBaseURI();
		request = getRequest();
	}

	@When("^the user makes a request with \"([^\"]*)\" date for \"([^\"]*)\" location$")
	public void the_user_makes_a_request_with_date_for_location(String day, String locationName) throws Throwable {
		if(day.equals("today")){
			response = request.get(configFileReader.getURI() + Resources.weatherForecastResource(getLocationId(locationName), getDate(0)));
		}else if(day.equals("tomorrow")){
			response = request.get(configFileReader.getURI() + Resources.weatherForecastResource(getLocationId(locationName), getDate(1)));
		}else if(day.equals("tomorrow+1")){
			response = request.get(configFileReader.getURI() + Resources.weatherForecastResource(getLocationId(locationName), getDate(2)));
		}else if(day.equals("tomorrow+2")){
			response = request.get(configFileReader.getURI() + Resources.weatherForecastResource(getLocationId(locationName), getDate(3)));
		}else{
			throw new RuntimeException("Day entered is not valid");
		}
	}

	@Then("^the server returns \"([^\"]*)\" weather state name as response$")
	public void the_server_returns_weather_state_name_as_response(String expectedWeatherStateName) throws Throwable {
			jsonPath = getResponseJsonPath(response);
			actualWeatherStateName = jsonPath.getJsonObject("[0].weather_state_name");
			Assert.assertThat(actualWeatherStateName, Matchers.equalToIgnoringCase(expectedWeatherStateName));
	}
	
	@Then("^the weather state abbrevation should be one or two characters$")
	public void the_weather_state_abbrevation_should_be_one_or_two_characters() throws Throwable {
		jsonPath = getResponseJsonPath(response);
		actualWeatherStateAbbr = jsonPath.getJsonObject("[0].weather_state_abbr");
		Assert.assertTrue("abbrevation should not be of 0 ", actualWeatherStateAbbr.length()>0);
		Assert.assertTrue("abbrevation should not be more that two characters", actualWeatherStateAbbr.length()<=2);
	}

}
