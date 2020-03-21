Feature: A description

  @Check
  Scenario: Test positive check flag
    Given enter site -checkFlag
    When messages panel -checkFlag
    And check flag
    Then exit program -checkFlag

  @CheckOut
  Scenario: Test positive check out flag
    Given enter site -checkOutFlag
    When messages panel -checkOutFlag
    And check out flag
    Then exit program -checkOutFlag