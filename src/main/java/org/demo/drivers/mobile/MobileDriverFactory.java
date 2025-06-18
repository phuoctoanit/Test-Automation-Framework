package org.demo.drivers.mobile;

import io.appium.java_client.AppiumDriver;

public class MobileDriverFactory {

    public static AppiumDriver getDriver(PlatformType platformType) throws Exception {

        MobileDriverManager driverManager = null;
        switch (platformType) {
            case IOS:
                driverManager = new IOSDriverManger();
            case ANDROID:
                //driverManager = new AndroidDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Unsupported platform type: " + platformType);
        }
        return driverManager.createDriver();
    }
}
