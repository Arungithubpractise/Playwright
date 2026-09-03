Feature: Frames and dialogs

  Scenario: Validate iframe content and accept alert
    Given I open the advanced page
    Then the iframe content contains "Frame content ready"
    When I click the alert button
    Then the alert is accepted
