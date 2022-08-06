package mobile.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.utils.MobileCommonUtils;

import static mobile.stepDefs.MobileHooks.*;
import static org.junit.Assert.*;
import static mobile.utils.MobileCommonUtils.*;


public class ApiDemoStepDefs {
    String actualOptionText;

    @Given("user gets text of Accessibility option")
    public void userGetsTextOfAccessibilityOption() {
        actualOptionText = MobileHooks.apiDemoHomePage.accessibilityOption.getText();
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
}
