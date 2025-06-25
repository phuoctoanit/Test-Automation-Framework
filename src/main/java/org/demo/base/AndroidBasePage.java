package org.demo.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all Android pages.
 * include any common methods or properties that all Android pages should have
 */
public class AndroidBasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    protected AndroidBasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Adjust the timeout as needed
    }
}
