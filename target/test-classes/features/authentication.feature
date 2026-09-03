Feature: Authentication and storage state

  Scenario: Persist storage state and reuse it in a new context
    Given I open the advanced page
    When I save browser storage state to "auth-state"
    Then the stored auth token is reused
