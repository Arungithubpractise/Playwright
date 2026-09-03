Feature: Network and API interception

  Scenario: Intercept a remote request with a mocked API response
    Given I open the advanced page
    When I mock the api response with "Mocked API response"
    Then the api result is "Mocked API response"
