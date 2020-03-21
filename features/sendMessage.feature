Feature: Send letter

  Scenario: Test positive steps screens
    Given enter site -sendMessage
    When messages panel -sendMessage
    And write panel
    And done write
    And send message
    Then ok! no error, exit from the program -sendMessage
