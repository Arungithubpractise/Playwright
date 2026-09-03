Feature: Sample Playwright smoke test

  Scenario: Open the mock page and verify core content
    Given I open the example page
    Then the page title contains "Dummy Browser Playground"
    And the page contains text "Dummy Browser Playground"
