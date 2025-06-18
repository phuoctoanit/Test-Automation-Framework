package org.demo.drivers.mobile;

import io.appium.java_client.AppiumDriver;

public interface MobileDriverManager {
    
    AppiumDriver createDriver() throws Exception;
}
