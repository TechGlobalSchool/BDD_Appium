@Regression
Feature: Api Demo Application

  @ValidateText
  Scenario: Get text of button
    Given user gets text of Accessibility option
    Then user validates that it is "Accessibility"

#  @ValidateCustomViewText
#  Scenario: Validate custom view text
#    Given user taps on "Accessibility"
#    Then user should be able to see "Custom View"
#
#  @ValidateInputBox
#  Scenario: Validate input box is displayed
#    Given user taps on Views
#    And user taps on Animation
#    And user taps on Shake
#    Then user should be able to see input box
#
#  @ValidateAllTexts
#  Scenario: Get texts of All options and validate them
#    Given user gets texts of all options and validates them
#      | Accessibility |
#      | Animation     |
#      | App           |
#      | Content       |
#      | Graphics      |
#      | Media         |
#      | NFC           |
#      | OS            |
#      | Preference    |
#      | Text          |
#      | Views         |