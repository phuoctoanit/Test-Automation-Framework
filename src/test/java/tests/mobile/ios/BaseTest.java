package tests.mobile.ios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void initSession() {
        // Initialize the mobile session here
        // This could include setting up Appium driver, capabilities, etc.
        // Example: MobileDriverManager.getInstance().startSession();
        System.out.println("Mobile session initialized.");
    }

    @AfterSuite
    public void tearDownSession() {
        // Clean up the mobile session here
        // This could include quitting the Appium driver, closing the app, etc.
        // Example: MobileDriverManager.getInstance().quitSession();
        System.out.println("Mobile session terminated.");
    }
}
