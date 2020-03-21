Feature: Testing the buttons

  @Aries
  Scenario: Positive testing the aries buttons
    Given enter mail.ru
    When click aries page
    And return home page
    Then Good, test positive!

  @Cloud
  Scenario: Positive testing the cloud buttons
    Given enter mail.ru -cloud
    When click cloud button
    And return home page -cloud
    Then Good, test positive! -cloud

  @Forecast
  Scenario: Positive testing the weather forecast buttons
    Given enter mail.ru -forecast
    When click forecast button
    And return home page -forecast
    Then Good, test positive! -forecast

  @SearchImage
  Scenario: Positive testing the image buttons
    Given enter mail.ru -image
    When click image button
    And return home page -image
    Then Good, test positive! -image

  @CorporationInfo
  Scenario: Positive testing corporation info buttons
    Given enter mail.ru -corporation info
    When click corporation info button
    Then Good, test positive! -corporation info