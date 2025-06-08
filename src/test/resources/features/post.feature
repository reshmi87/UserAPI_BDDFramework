@post
Feature: Post User Api

Scenario Outline: Verify the new user creation is successful using POST User Api request with valid mandatory and non mandatory fields	
Given User creates  the POST User Api request with valid values from <Rownumber> for every field in the json
When POST User Api request is sent
Then Success message is displayed and all values in the <Rownumber> matches to the values in the response
Examples:
|Rownumber|
|1|