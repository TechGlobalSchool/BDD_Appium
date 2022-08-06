package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemoHomePage {

    public ApiDemoHomePage(AndroidDriver<AndroidElement> androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    /*
    resource-id => id
    accessibility id => accessibility

     */

    @AndroidFindBy(accessibility = "Accessibility")
    public AndroidElement accessibilityOption;

//    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Custom View\")")
//    public AndroidElement customView;
//
//    @AndroidFindBy(accessibility = "Views")
//    public AndroidElement viewsOption;
//
//    @AndroidFindBy(id = "android:id/text1")
//    public List<AndroidElement> allMainMenuOptions;
//
//    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Accessibility\")")
//    public AndroidElement accessibilityOption2;

}
