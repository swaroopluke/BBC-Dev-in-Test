Feature: OpenMetaWeather API Weather Forecast Functionality

Background: User to request endpoint
Given the user is about to make a request to the endpoint

#check if the weather forecast response for London for today is as expected
#----------(/api/location/(woeid)/(date)/)------------
Scenario: User to check todays weather forecast for LocationDay method 
When the user makes a request with "today" date for "London" location
Then the server returns "Heavy Cloud" weather state name as response

Scenario: User to check weather state abbrevation for LocationDay method 
When the user makes a request with "tomorrow" date for "London" location
Then the weather state abbrevation should be one or two characters


#@manual 
#----------/api/location/(woeid)/(date)/--------------

#Scenario: User to verify applicable date for LocationDay method 
#When the user makes a request with "2019/09/13" date for "London" location
#Then the input date should match with application date

#--------check Location method (/api/location/(woeid)/)---------

#Scenario: User to verify weather forecast for Location method 
#When the user makes a request with "44418" location
#Then the server returns a response with 5 day forecast

#Scenario: User to verify Location method with invalid locationId
#When the user makes a request with "448" location
#Then the server returns a response with status code "404"

#Scenario: User to verify sources field for Location method
#When the user makes a request with "44418" location
#Then the sources in response should contain title and url

#Scenario: User to verify time field for Location method
#When the user makes a request with "44418" location
#Then the time in response should contain date and time values


