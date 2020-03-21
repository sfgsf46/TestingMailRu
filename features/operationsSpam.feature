Feature: Operations from spam

  @ToSpam
  Scenario: Positive spam test
    Given enter mail.ru -check
    When messages panel -check
    And Moving of spam -check
    Then Exit program -check

  @OfSpam
  Scenario: Positive spam test
    Given enter mail.ru -checkOut
    When messages panel -checkOut
    And Moving of spam -checkOut
    Then Exit program -checkOut