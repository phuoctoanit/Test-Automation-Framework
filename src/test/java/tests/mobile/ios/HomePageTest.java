package tests.mobile.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Allure;
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

        Allure.step("Initializing the test environment for iOS platform: " + platform);
        driver = MobileDriverFactory.getDriver(PlatformType.valueOf(platform.toUpperCase()));
        IOSPageManager iosPageManager = new IOSPageManager((IOSDriver) driver);
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        iosWelcomePage = iosPageManager.getIosHomePage();
    }

    @Test
    public void navigateToHome() {
        Logger.info("Navigating to the Welcome page Fitness.");
        Allure.step("Navigating to the Welcome page Fitness.");
        iosWelcomePage.goToSummaryPage();

        Logger.info("Verifying the Summary button is visible on the iOS Home Page.");
        Allure.step("Verifying the Summary button is visible on the iOS Home Page.");
        iosWelcomePage.accessToSummaryPage();
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
