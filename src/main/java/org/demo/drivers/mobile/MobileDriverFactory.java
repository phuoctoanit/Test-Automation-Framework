package org.demo.drivers.mobile;

import io.appium.java_client.AppiumDriver;
import org.demo.drivers.mobile.implement.MobileDriverImplement;
import org.demo.drivers.mobile.managers.AndroidDriverManager;
import org.demo.drivers.mobile.managers.IOSDriverManager;

public class MobileDriverFactory {

    public static AppiumDriver getDriver(PlatformType platformType) throws Exception {

        MobileDriverImplement driverManager = null;
        switch (platformType) {
            case IOS:
                driverManager = new IOSDriverManager();
            case ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Unsupported platform type: " + platformType);
        }
        return driverManager.createDriver();
    }
}
