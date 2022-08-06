package mobile.pages.mobilePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ApiDemoAccessibilityPage {
    public ApiDemoAccessibilityPage(AndroidDriver<AndroidElement> androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(accessibility = "Custom View")
    public AndroidElement customViewOption;

    @AndroidFindBy(id = "io.appium.android.apis:id/pw")
    public AndroidElement passwordInputBox;
}
