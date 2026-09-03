Feature: Browser contexts and multi-page support

  Scenario: Open a second page in the same browser context
    Given I open the advanced page
    When I open a second page in the same browser context
    Then multiple pages are supported
