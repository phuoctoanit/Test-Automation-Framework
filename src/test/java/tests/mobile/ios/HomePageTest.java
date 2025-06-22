package tests.mobile.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.*;
import org.demo.drivers.mobile.MobileDriverFactory;
import org.demo.drivers.mobile.PlatformType;
import org.demo.managers.IOSPageManager;
import org.demo.pages.mobile.ios.IOSWelcomePage;
import org.demo.utils.Logger;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageTest extends BaseTest{

    private AppiumDriver driver;
    private IOSWelcomePage iosWelcomePage;

    @Parameters("platform")
    @BeforeClass
    public void setUp(@Optional("IOS") String platform) throws Exception {
        Logger.info("Initializing the test environment for iOS platform: " + platform);
        Allure.step("Initializing the test environment for iOS platform: " + platform);
        driver = MobileDriverFactory.getDriver(PlatformType.valueOf(platform.toUpperCase()));
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        IOSPageManager iosPageManager = new IOSPageManager((IOSDriver) driver);

        iosWelcomePage = iosPageManager.getIosHomePage();
    }

    @Test(description = "Verify access to the iOS Home Page and Summary button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify access to the iOS Home Page and Summary button")
    @Story("User Story 2 (Mobile iOS)")
    public void navigateToHome() {
        Logger.info("Navigating to the Welcome page Fitness.");
        Allure.step("Navigating to the Welcome page Fitness.");
        iosWelcomePage.goToSummaryPage();

        Logger.info("Verifying the Summary button is visible on the iOS Home Page.");
        Allure.step("Verifying the Summary button is visible on the iOS Home Page.");
        iosWelcomePage.createNewReminder("Test Reminder", "This is a test node for the reminder.");
    }

    @AfterClass
    public void tearDown() {
        Logger.info("Tearing down the test environment.");
        Allure.step("Tearing down the test environment.");
        if (driver != null) {
            driver.quit();
        }

        // Shut down simulator
        try {
            String undid = "F82B0A55-1628-4162-BDC2-492E864C4515"; // Replace with your simulator UDID
            Runtime.getRuntime().exec("xcrun simctl shutdown " + undid);
        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
    }
}
