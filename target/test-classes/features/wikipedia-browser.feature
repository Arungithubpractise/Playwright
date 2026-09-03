Feature: Wikipedia browser action

  Scenario: Type into the Wikipedia search box
    Given I open the Wikipedia page
    When I type "Playwright" in the Wikipedia search box
    Then the Wikipedia search box contains "Playwright"
