package tests.mobile.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import io.qameta.allure.*;
import org.demo.drivers.mobile.MobileDriverFactory;
import org.demo.drivers.mobile.PlatformType;
import org.demo.managers.AndroidPageManager;
import org.demo.managers.IOSPageManager;
import org.demo.pages.mobile.android.AndroidHomePage;
import org.demo.utils.Logger;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest{

    private AppiumDriver driver;
    private AndroidHomePage androidHomePage;

    @Parameters("platform")
    @BeforeClass
    public void setUp(@Optional("android") String platform) throws Exception {
        Logger.info("Initializing the test environment for Android platform: " + platform);
        Allure.step("Initializing the test environment for android platform: " + platform);
        driver = MobileDriverFactory.getDriver(PlatformType.valueOf(platform.toUpperCase()));
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        AndroidPageManager androidPageManager = new AndroidPageManager((AndroidDriver) driver);
        androidHomePage = androidPageManager.getAndroidHomePage();
    }

    @Test(description = "Verify access to the Home Page and Summary button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify access to the iOS Home Page and Summary button")
    @Story("User Story 2 (Mobile Android)")
    public void homePageTest(){
        Logger.info("Navigating to the Welcome page Fitness.");
        Allure.step("Navigating to the Welcome page Fitness.");
        androidHomePage.navigateToWelcomePage();
    }

    @AfterClass
    public void tearDown() {
        Logger.info("Tearing down the test environment.");
        Allure.step("Tearing down the test environment.");
        if (driver != null) {
            driver.quit();
        }
    }
}
