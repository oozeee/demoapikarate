Feature: Verifying View Requests API

  Background:
    Given url baseAPIUrl
    * def requestsSchema = read('classpath:demoTest/viewRequests/viewRequestsSchema.json')
    * print 'The value of requestsSchema is:\n', karate.pretty(requestsSchema)

    * def loginDetails = call read('classpath:demoTest/userLogin/userLogin.feature')

  Scenario: verify view requests API returns correct status code (200) and schema
    When path '/viewrequests'
    And header Authorization = loginDetails.response.authtoken
    And method GET
    Then status 200
    And match response == "#[]"
    And match response ==
    """
    '#[] requestsSchema'
    """
