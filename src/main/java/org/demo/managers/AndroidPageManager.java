package org.demo.managers;

import io.appium.java_client.android.AndroidDriver;
import org.demo.pages.mobile.android.AndroidHomePage;

public class AndroidPageManager {

    private final AndroidDriver driver;
    private AndroidHomePage androidHomePage;

    public AndroidPageManager(AndroidDriver driver) {
        // Initialization logic if needed
        this.driver = driver;
    }

    public AndroidHomePage getAndroidHomePage() {
        if (this.androidHomePage == null) {
            this.androidHomePage = new AndroidHomePage(this.driver);
        }
        return this.androidHomePage;
    }
}
