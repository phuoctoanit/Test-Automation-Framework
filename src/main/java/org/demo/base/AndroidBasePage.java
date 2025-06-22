package org.demo.base;

import io.appium.java_client.android.AndroidDriver;

public class AndroidBasePage {

    protected AndroidDriver driver;

    protected AndroidBasePage(AndroidDriver driver) {
        this.driver = driver;
    }
}
