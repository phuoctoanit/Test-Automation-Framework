package org.demo.base;

import io.appium.java_client.android.AndroidDriver;

/**
 * Base class for all Android pages.
 * include any common methods or properties that all Android pages should have
 */
public class AndroidBasePage {

    protected AndroidDriver driver;

    protected AndroidBasePage(AndroidDriver driver) {
        this.driver = driver;
    }
}
