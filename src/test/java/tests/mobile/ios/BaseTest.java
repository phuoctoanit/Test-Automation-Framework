package tests.mobile.ios;

import org.demo.listeners.MobileReportingListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MobileReportingListener.class)
@Test(groups = "mobile")
public class BaseTest {

    @BeforeSuite
    public void initSession() {
        // Initialize the mobile session here
        // This could include setting up Appium driver, capabilities, etc.
        // Example: MobileDriverManager.getInstance().startSession();
        System.out.println("Mobile session initialized for ios testing.");
    }

    @AfterSuite
    public void tearDownSession() {
        // Clean up the mobile session here
        // This could include quitting the Appium driver, closing the app, etc.
        // Example: MobileDriverManager.getInstance().quitSession();
        System.out.println("Mobile session terminated.");
    }
}
