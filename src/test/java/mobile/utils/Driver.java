package mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static AndroidDriver<AndroidElement> androidDriver;
    private static WebDriver webDriver;

    /**
     * This method sets up DesiredCapabilities
     * for Android Emulator, Appium Server and mobile application
     *
     * @return
     * @throws MalformedURLException
     */

    public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
        if (androidDriver == null) {
            File appFile = new File(ConfigReader.getProperty("apkAppPath")); //stores the app path
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // setting up the mobile device with below values

            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability("app", appFile.getAbsolutePath()); // absolute path not content root

            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub"); // server url comes in here
            androidDriver = new AndroidDriver<>(appiumServerUrl, desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return androidDriver;
    }

    public static void quitDriver() {
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
    }
}
