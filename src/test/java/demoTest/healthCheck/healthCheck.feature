Feature: Testing health check API

  Background:
    Given url baseAPIUrl

  Scenario: verify health check API returns correct status code (200) and schema
    When path '/healthcheck'
    And method GET
    Then status 200
    And match response.message == 'In good health....'