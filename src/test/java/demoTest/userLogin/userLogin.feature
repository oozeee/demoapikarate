Feature: Testing User Login API

  Background:
    Given url baseAPIUrl
    * def userLoginSchema = read ('classpath:demoTest/userLogin/userLoginSchema.json')
    * json requestBody = '{"username": '+apiUsername+',"password": '+apiPassword+'}'

  Scenario: Verify User Login API returns correct status code (200) and schema for valid credentials
    When path '/login'
    And request requestBody
    And method POST
    Then status 200
    And match response == userLoginSchema
    And match response.username == apiUsername