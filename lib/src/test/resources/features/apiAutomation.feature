Feature: Test OpenWeather Map
Given: OpenWeatherMap API to register stations

@APIautomation
Scenario Outline: Attempt to register a station without a key

	When User attempts to register a station without API key
	Then A status code of 401 gets returned and a message is also included
	
Scenario Outline: Register the first station with valid key

	When User attempts to register the first station with a valid key
	Then A status code of 201 gets returned	
	When Script makes a GET request for the first station
	Then The correct JSON response is sent
	
Scenario Outline:	Register the second station with valid key
  When User attempts to register the second station with a valid key
	Then A status code of 201 gets returned for second station	
	When Script makes a GET request for the second station
	Then The correct JSON response is sent for second station
