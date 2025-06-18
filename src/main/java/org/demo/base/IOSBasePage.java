package org.demo.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSBasePage {

    protected IOSDriver driver;

    protected IOSBasePage(IOSDriver driver) {
        this.driver = driver;
    }
}
