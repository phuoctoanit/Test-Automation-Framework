package org.demo.managers;

import io.appium.java_client.ios.IOSDriver;
import org.demo.pages.mobile.ios.IOSWelcomePage;

/**
 * This class manages the iOS pages for the application.
 * It initializes and provides access to the iOS-specific pages.
 */
public class IOSPageManager {

    private final IOSDriver driver;
    private IOSWelcomePage iosWelcomePage;

    public IOSPageManager(IOSDriver driver) {
        // Initialization logic if needed
        this.driver = driver;
    }

    public IOSWelcomePage getIosHomePage() {
        if(this.iosWelcomePage == null) {
            this.iosWelcomePage = new IOSWelcomePage(this.driver);
        }
        return this.iosWelcomePage;
    }
}
