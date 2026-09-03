Feature: Locator examples

  Scenario: Use element locators to validate visible controls
    Given I open the example page
    Then the username field is visible
    And the submit button is visible

  Scenario: Use data-testid to open the modal
    Given I open the example page
    When I click the open modal button
    Then the modal dialog is visible
