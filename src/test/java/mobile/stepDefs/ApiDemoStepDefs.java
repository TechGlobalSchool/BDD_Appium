package mobile.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mobile.utils.MobileCommonUtils;

import static mobile.stepDefs.MobileHooks.androidDriver;
import static mobile.stepDefs.MobileHooks.apiDemoAccessibilityPage;
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
}
