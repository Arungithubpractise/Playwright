Feature: Screenshot and tracing

  Scenario: Capture a screenshot and trace output
    Given I open the advanced page
    When I capture a screenshot named "screenshot"
    Then the screenshot file exists
    When I record a trace named "trace"
    Then the trace file exists
