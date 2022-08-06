Feature: Chrome Testing

#  Background:
#    Given user taps on "ACCEPT & CONTINUE"
#    And user taps on "NO THANKS"
#    And user types "https://techglobalschool.com" on search box and presses enter on device

  @openChrome
  Scenario: Validate Title
    Given user navigates to "https://techglobalschool.com" on device
    And user validates title is "SDET Bootcamp | TechGlobal" on device

  @classTaskScenarioOutlineOnDevice
  Scenario Outline: Validate the "<title>" for given "<url>"
    Given user navigates to "<url>" on device
    When user types "keyholder" on search box and presses enter on device
    Then user validates title is "<title>" on device

    Examples:
      | url                     | title                  |
      | https://www.amazon.com/ | Amazon.com : keyholder |
      | https://www.ebay.com/   | keyholder \| eBay      |

