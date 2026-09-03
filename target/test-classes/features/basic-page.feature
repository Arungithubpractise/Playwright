Feature: Basic page checks

  Scenario: Open the mock page and verify the title and body
    Given I open the example page
    Then the page title contains "Dummy Browser Playground"
    And the page contains text "Dummy Browser Playground"
