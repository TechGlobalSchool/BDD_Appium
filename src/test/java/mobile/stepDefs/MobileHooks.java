package mobile.stepDefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import mobile.pages.browserPages.AmazonHomePage;
import mobile.pages.browserPages.EbayHomePage;
import mobile.pages.mobilePages.ApiDemoAccessibilityPage;
import mobile.pages.mobilePages.ApiDemoGraphicsPage;
import mobile.pages.mobilePages.ApiDemoHomePage;
import mobile.pages.mobilePages.ApiDemoTextPage;
import mobile.utils.ConfigReader;
import mobile.utils.Driver;
import org.openqa.selenium.WebDriver;


public class MobileHooks {

    public static AndroidDriver<AndroidElement> androidDriver;
    public static ApiDemoHomePage apiDemoHomePage;
    public static ApiDemoAccessibilityPage apiDemoAccessibilityPage;
    public static ApiDemoGraphicsPage apiDemoGraphicsPage;
    public static ApiDemoTextPage apiDemoTextPage;

    public static WebDriver webDriver;
    public static EbayHomePage ebayHomePage;
    public static AmazonHomePage amazonHomePage;


    @Before
    public void setup() throws Exception {
        switch (ConfigReader.getProperty("testing")) {
            case "browser":
                webDriver = Driver.getWebDriver();
                ebayHomePage = new EbayHomePage(webDriver);
                amazonHomePage = new AmazonHomePage(webDriver);
                break;
            case "app":
                androidDriver = Driver.getAndroidDriver();
                apiDemoHomePage = new ApiDemoHomePage(androidDriver);
                apiDemoAccessibilityPage = new ApiDemoAccessibilityPage(androidDriver);
                apiDemoGraphicsPage = new ApiDemoGraphicsPage(androidDriver);
                apiDemoTextPage = new ApiDemoTextPage(androidDriver);
                break;
            default:
                throw new Exception("Testing value not found from configuration.properties!");
        }
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
