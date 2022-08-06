package mobile.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.utils.MobileCommonUtils;
import mobile.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static mobile.stepDefs.MobileHooks.*;
import static org.junit.Assert.*;
import static mobile.utils.MobileCommonUtils.*;


public class ApiDemoStepDefs {
    String actualOptionText;

    @Given("user gets text of Accessibility option")
    public void userGetsTextOfAccessibilityOption() {
        actualOptionText = apiDemoHomePage.accessibilityOption.getText();
    }

    @Then("user validates that it is {string}")
    public void userValidatesThatItIs(String expectedOptionText) {
        assertEquals(expectedOptionText, actualOptionText);
    }

    @Given("user taps on {string}")
    public void userTapsOn(String visibleText) {
        getElementByText(androidDriver, visibleText).click();
    }

    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String expectedElementText) {
        assertTrue(apiDemoAccessibilityPage.customViewOption.isDisplayed());
        assertEquals(expectedElementText, apiDemoAccessibilityPage.customViewOption.getText());
    }

    @Then("user should be able to see input box")
    public void userShouldBeAbleToSeeInputBox() {
        assertTrue(apiDemoAccessibilityPage.passwordInputBox.isDisplayed());
        assertTrue(apiDemoAccessibilityPage.passwordInputBox.isEnabled());
    }

    @Given("user gets texts of all options and validates them")
    public void userGetsTextsOfAllOptionsAndValidatesThem(DataTable expectedOptionTexts) {
        for (int i = 0; i < expectedOptionTexts.asList().size(); i++) {
            assertEquals(
                    expectedOptionTexts.asList().get(i),
                    apiDemoHomePage.allOptions.get(i).getText()
            );
        }
    }

    @Given("user gets all elements then user validates size of element is {int}")
    public void userGetsAllElementsThenUserValidatesSizeOfElementIs(int expectedSize) {
        assertEquals(expectedSize, apiDemoHomePage.allElements.size());
    }

    @Given("user gets text of Graphics option then user validates that it is {string}")
    public void userGetsTextOfGraphicsOptionThenUserValidatesThatItIs(String expectedText) {
        assertEquals(expectedText, apiDemoHomePage.graphicsOption.getText());
    }

    @When("user scrolls and taps on {string}")
    public void userScrollsAndTapsOn(String visibleText) {
        scrollAndClick(androidDriver, visibleText);
    }

    @Then("user validates picture is displayed")
    public void userValidatesPictureIsDisplayed() {
        assertTrue(apiDemoGraphicsPage.picture.isDisplayed());
    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        assertEquals(expectedTitle, apiDemoGraphicsPage.verticesTitle.getText());
    }

    @Then("user validates options are displayed")
    public void userValidatesOptionsAreDisplayed(DataTable expectedOptionTexts) {
        assertTextForTwoLists(expectedOptionTexts, apiDemoTextPage.textOptions);
    }

    @And("user validates the message is {string}")
    public void userValidatesTheMessageIs(String expectedText) {
        assertEquals(expectedText, apiDemoTextPage.logTextBox.getText().trim());
    }

    @Given("user taps by coordinates {int}, {int} on {string}")
    public void userTapsByCoordinatesOn(int x, int y, String elementText) {
        tapByCoordinates(androidDriver, x, y);
        System.out.println("Driver clicked on " + elementText + " element!");
    }

    @And("user presses for {int} seconds long by coordinates {int}, {int} to {string}")
    public void userPressesForSecondsLongByCoordinatesTo(int seconds, int x, int y, String elementText) {
        pressByCoordinates(androidDriver, x, y, seconds);
        System.out.println("Driver clicked on " + elementText + " element!");
    }

    @And("user should see {string}")
    public void userShouldSee(String expectedText) {
        assertEquals(expectedText, getElementByText(androidDriver, expectedText).getText());
    }

    @When("user swipes down {int} times by coordinates x {int} yStart {int} and yEnd {int} and taps on {string}")
    public void userSwipesDownTimesByCoordinatesXYStartAndYEndAndTapsOn(int times, int x, int yStart, int yEnd, String elementText) {
        for (int i = 0; i < times; i++) verticalSwipeByCoordinates(androidDriver, x, yStart, yEnd);
        getElementByText(androidDriver, elementText).click();
    }

    @Given("user navigates to {string} on device")
    public void userNavigatesToOnDevice(String url) {
        webDriver.get(url);
    }

    @And("user validates title is {string} on device")
    public void userValidatesTitleIsOnDevice(String expectedTitle) {
        WaitUtils.waitForPageTitle(webDriver, expectedTitle);
        Assert.assertEquals(expectedTitle, webDriver.getTitle());
    }

    @When("user types {string} on search box and presses enter on device")
    public void userTypesOnSearchBoxAndPressesEnterOnDevice(String searchText) {
        if(webDriver.getCurrentUrl().contains("ebay")) {
            ebayHomePage.searchBox.sendKeys(searchText + Keys.ENTER);
        } else if(webDriver.getCurrentUrl().contains("amazon")) {
            amazonHomePage.searchBox.sendKeys(searchText + Keys.ENTER);
        }
    }
}
