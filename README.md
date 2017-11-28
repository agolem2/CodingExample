QA Coding Example

User Story
You have been assigned as an independent auditor to verify certain functionality of travel websites. The use cases are twofold (web and API).

Web: For the travel website - Kayak, verify via the UI the lowest car rental price for a 2-day rental when returning to same location is lower than
when returning to a different location. If an anomaly is found, your test should fail and output the dates, source/destination airport and lowest
prices for each failed search.

API: The website Carrentals.com exposes an API that returns cities in the world with search query parameter in the name. See: https://pia.service
s.carrentals.com/api/v2/destinations?language=us&limit=1000&q=san
Verify that more than two destinations and countries are returned in the result payload for a common search keyword like “San”.

Automation Tasks
1.) Web: Automate via the UI, the scenario mentioned in User Story and include any validations you deem necessary.
Navigate to kayak.com/cars. For purpose of simplicity, choose any random date in the next 3 months and a highly available airport like SFO.
Sample at least 5 different dates in the 3 month period. Once on the search results page, record the lowest price returned (first result in the list).
Now unselect the checkbox for “Return to same location” and enter another highly available airport like LAX as the return location. Compare the
lowest price for this search with the previous recorded price and assert that the one-way rental price is higher. If the test fails - output the dates,
source/destination airport and lowest prices for each failed search.

2.) API: Write a test that makes a GET request to the API mentioned in the user story and verifies that more than two destinations and countries
are returned in the response. Include any other validations you deem necessary.
In addition, write a method to display the names of all the countries in response, corresponding number of cities per country and a comma
separate value of all cities for each country in the response.
