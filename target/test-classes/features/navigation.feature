Feature: Navigation examples

  Scenario: Reload page and keep the app available
    Given I open the example page
    When I reload the page
    Then the page should still be open
