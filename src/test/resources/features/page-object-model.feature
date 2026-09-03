Feature: Page Object Model examples

  Scenario: Use a page object to interact with the mock app
    Given I open the mock page
    Then the mock page title is "Dummy Browser Playground"
    And the username field is ready
    When I enter "Ada" in the username field
    And I select "United Kingdom" from the country drop-down
    And I submit the form
    Then the success banner shows "Success! Form submitted."

  Scenario: Open modal through page object
    Given I open the mock page
    Then the username field is ready
    And the modal opens
