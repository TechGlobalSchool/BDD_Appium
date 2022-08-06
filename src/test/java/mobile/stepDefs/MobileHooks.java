package mobile.stepDefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import mobile.pages.ApiDemoAccessibilityPage;
import mobile.pages.ApiDemoGraphicsPage;
import mobile.pages.ApiDemoHomePage;
import mobile.utils.Driver;


public class MobileHooks {

    public static AndroidDriver<AndroidElement> androidDriver;
    public static ApiDemoHomePage apiDemoHomePage;
    public static ApiDemoAccessibilityPage apiDemoAccessibilityPage;
    public static ApiDemoGraphicsPage apiDemoGraphicsPage;


    @Before
    public void setup() throws Exception {
        androidDriver = Driver.getAndroidDriver();
        apiDemoHomePage = new ApiDemoHomePage(androidDriver);
        apiDemoAccessibilityPage = new ApiDemoAccessibilityPage(androidDriver);
        apiDemoGraphicsPage = new ApiDemoGraphicsPage(androidDriver);
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
