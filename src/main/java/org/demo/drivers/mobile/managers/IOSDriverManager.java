package org.demo.drivers.mobile.managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.demo.drivers.mobile.implement.MobileDriverImplement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSDriverManager implements MobileDriverImplement {

    @Override
    public AppiumDriver createDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 16 Pro");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "18.5"); // Adjust as needed
        caps.setCapability("appium:udid", "F82B0A55-1628-4162-BDC2-492E864C4515");
        caps.setCapability("appium:bundleId", "com.apple.Fitness"); // Replace with the path to your app
        caps.setCapability("appium:noReset", false);

        //Only work on simulator, to set permissions for the app, and need instal
        //brew tap wix/brew
        //brew install applesimutils

        String permissionsJson = "{"
            + "\"com.apple.Fitness\": {"
            +     "\"camera\": \"YES\","
            +     "\"contacts\": \"YES\","
            +     "\"location\": \"yes\""
            + "}"
            + "}";
        caps.setCapability("appium:permissions", permissionsJson);
        //caps.setCapability("appium:fullReset", true);

        return new IOSDriver(new URL("http://localhost:4723/"), caps);
    }
}
