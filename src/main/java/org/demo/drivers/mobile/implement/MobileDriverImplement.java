package org.demo.drivers.mobile.implement;

import io.appium.java_client.AppiumDriver;

/**
 * Interface for creating mobile drivers.
 * This interface defines a method to create an AppiumDriver instance.
 */
public interface MobileDriverImplement {
    
    AppiumDriver createDriver() throws Exception;
}
