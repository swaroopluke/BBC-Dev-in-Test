$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/features/weather.feature");
formatter.feature({
  "line": 1,
  "name": "OpenMetaWeather API Weather Forecast Functionality",
  "description": "",
  "id": "openmetaweather-api-weather-forecast-functionality",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "User to request endpoint",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the user is about to make a request to the endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherStepDefs.the_user_is_about_to_make_a_request_to_the_endpoint()"
});
formatter.result({
  "duration": 471878754,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 6,
      "value": "#check if the weather forecast response for London for today is as expected"
    },
    {
      "line": 7,
      "value": "#----------(/api/location/(woeid)/(date)/)------------"
    }
  ],
  "line": 8,
  "name": "User to check todays weather forecast for LocationDay method",
  "description": "",
  "id": "openmetaweather-api-weather-forecast-functionality;user-to-check-todays-weather-forecast-for-locationday-method",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the user makes a request with \"today\" date for \"London\" location",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the server returns \"Heavy Cloud\" weather state name as response",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "today",
      "offset": 31
    },
    {
      "val": "London",
      "offset": 48
    }
  ],
  "location": "WeatherStepDefs.the_user_makes_a_request_with_date_for_location(String,String)"
});
formatter.result({
  "duration": 1812266509,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Heavy Cloud",
      "offset": 20
    }
  ],
  "location": "WeatherStepDefs.the_server_returns_weather_state_name_as_response(String)"
});
formatter.result({
  "duration": 110173769,
  "error_message": "java.lang.AssertionError: \nExpected: equalToIgnoringCase(\"Heavy Cloud\")\n     but: was Light Cloud\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\n\tat org.junit.Assert.assertThat(Assert.java:956)\n\tat org.junit.Assert.assertThat(Assert.java:923)\n\tat stepDefinitions.WeatherStepDefs.the_server_returns_weather_state_name_as_response(WeatherStepDefs.java:54)\n\tat ✽.Then the server returns \"Heavy Cloud\" weather state name as response(src/main/java/features/weather.feature:10)\n",
  "status": "failed"
});
formatter.background({
  "line": 3,
  "name": "User to request endpoint",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "the user is about to make a request to the endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherStepDefs.the_user_is_about_to_make_a_request_to_the_endpoint()"
});
formatter.result({
  "duration": 563770,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User to check weather state abbrevation for LocationDay method",
  "description": "",
  "id": "openmetaweather-api-weather-forecast-functionality;user-to-check-weather-state-abbrevation-for-locationday-method",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "the user makes a request with \"tomorrow\" date for \"London\" location",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the weather state abbrevation should be one or two characters",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "tomorrow",
      "offset": 31
    },
    {
      "val": "London",
      "offset": 51
    }
  ],
  "location": "WeatherStepDefs.the_user_makes_a_request_with_date_for_location(String,String)"
});
formatter.result({
  "duration": 905352829,
  "status": "passed"
});
formatter.match({
  "location": "WeatherStepDefs.the_weather_state_abbrevation_should_be_one_or_two_characters()"
});
formatter.result({
  "duration": 54163107,
  "status": "passed"
});
});