package org.demo.base;

import io.appium.java_client.ios.IOSDriver;

public class IOSBasePage {

    protected IOSDriver driver;

    protected IOSBasePage(IOSDriver driver) {
        this.driver = driver;
    }

    // Include any common methods or properties that all iOS pages should have
}
