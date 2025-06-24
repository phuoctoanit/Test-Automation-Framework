package org.demo.drivers.mobile.managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.demo.drivers.mobile.PlatformType;
import org.demo.drivers.mobile.implement.MobileDriverImplement;
import org.demo.utils.CapabilitiesLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * AndroidDriverManager is responsible for creating an instance of AndroidDriver
 * with the appropriate capabilities and URL.
 */
public class AndroidDriverManager implements MobileDriverImplement {

    @Override
    public AppiumDriver createDriver() throws Exception {
        DesiredCapabilities caps = CapabilitiesLoader.getCapability(PlatformType.ANDROID);
        return new AndroidDriver(new URL(CapabilitiesLoader.getURL(PlatformType.ANDROID)), caps);
    }
}
