@Regression
Feature: Api Demo Application

  @ValidateText
  Scenario: Get text of button
    Given user gets text of Accessibility option
    Then user validates that it is "Accessibility"

  @ValidateCustomViewText
  Scenario: Validate custom view text
    Given user taps on "Accessibility"
    Then user should be able to see "Custom View"

  @ValidateInputBox
  Scenario: Validate input box is displayed
    Given user taps on "Views"
    And user taps on "Animation"
    And user taps on "Shake"
    Then user should be able to see input box

  @ValidateAllTexts
  Scenario: Get texts of All options and validate them
    Given user gets texts of all options and validates them
      | Accessibility |
      | Animation     |
      | App           |
      | Content       |
      | Graphics      |
      | Media         |
      | NFC           |
      | OS            |
      | Preference    |
      | Text          |
      | Views         |

  @ValidateSizeOfElement
  Scenario: Get All Elements with ClassName
    Given user gets all elements then user validates size of element is 12

  @ValidateTextWithXpath
  Scenario: Get text of button
    Given user gets text of Graphics option then user validates that it is "Graphics"

  @TapAndScrollToElement
  Scenario: Tap to Graphics and Scroll to Vertices and Tap to Vertices
    Given user taps on "Graphics"
    When user scrolls and taps on "Vertices"
    Then user validates picture is displayed
    Then user validates title is "Graphics/Vertices"

  @TapAndValidateMessage
  Scenario: Tap to Text option and validate details
    Given user taps on "Text"
    Then user validates options are displayed
      | Linkify | LogTextBox | Marquee |
    And user taps on "LogTextBox"
    And user taps on "ADD"
    And user validates the message is "This is a test"
    And user taps on "DO NOTHING"
    And user validates the message is "This is a test"

  @classTaskCoordinatesTap
  Scenario: Long Press element
    Given user taps by coordinates 88, 1550 on "Views"
    When user taps by coordinates 184, 1300 on "Expandable Lists"
    Then user taps by coordinates 224, 268 on "1. Custom Adapter"
    And user presses for 3 seconds long by coordinates 211, 241 to "People Names"
    And user should see "Sample menu"