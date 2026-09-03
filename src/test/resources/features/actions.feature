Feature: Action examples

  Scenario: Fill form fields and submit
    Given I open the example page
    When I fill the username with "Ada"
    And I select "United Kingdom" from the country dropdown
    And I click the submit button
    Then the success banner is visible
    And the value in username field is "Ada"
