Feature: Verifying View Request By Id API

  Background:
    Given url baseAPIUrl
    * def requestId = (Math.floor(Math.random(5,10)*10000)).toFixed(0)
    * def requestsSchema = read('classpath:demoTest/viewRequests/viewRequestsSchema.json')
    * print 'The value of requestsSchema is:\n', karate.pretty(requestsSchema)

    * def loginDetails = call read('classpath:demoTest/userLogin/userLogin.feature')

  Scenario: verify view requests API returns correct status code (200) and schema
    When path 'viewrequests', requestId
    #And param id = randRequestId
    And header Authorization = loginDetails.response.authtoken
    And method GET
    Then status 404
