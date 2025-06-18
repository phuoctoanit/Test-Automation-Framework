package org.demo.drivers.web;

import org.demo.managers.WebPageManager;
import org.openqa.selenium.WebDriver;

public class WebDriverSession {

    private static WebDriver driver;
    private static WebPageManager webPageManager;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setWebPageManager(WebPageManager manager) {
        webPageManager = manager;
    }

    public static WebPageManager getWebPageManager() {
        return webPageManager;
    }
}
