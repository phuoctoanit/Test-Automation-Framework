package org.demo.drivers.mobile.managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.demo.drivers.mobile.implement.MobileDriverImplement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverManager implements MobileDriverImplement {
    @Override
    public AppiumDriver createDriver() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        return new AndroidDriver(new URL("http://localhost:4725/"), caps);
    }
}
