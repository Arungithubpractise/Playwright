Feature: Waiting examples

  Scenario: Wait for an element before asserting
    Given I open the example page
    Then the page waits for the username field
    And the username field is visible
