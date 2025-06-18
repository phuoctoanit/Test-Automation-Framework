package org.demo.pages.mobile.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.demo.base.IOSBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class IOSWelcomePage extends IOSBasePage {

    AppiumBy continueButton = (AppiumBy) AppiumBy.accessibilityId("Fitness.WelcomeView.Continue");
    // Define any locators or elements specific to the iOS home page
    public IOSWelcomePage(IOSDriver driver) {
        super(driver);
    }

    public void goToSummaryPage() {
        // Example test method
        Logger.info("Clicking on the Continue button on the iOS Home Page.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement continueEle = wait.until(d -> d.findElement(AppiumBy.accessibilityId("Fitness.WelcomeView.Continue")));
        continueEle.click();
    }

    public void accessToSummaryPage(){
        Logger.info("Verifying the Summary button is visible on the iOS Home Page.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement summaryEle = wait.until(d -> d.findElement(AppiumBy.accessibilityId("Fitness.TabBar.Summary")));
        Assert.assertTrue(summaryEle.isDisplayed(), "Summary button is not visible!");
    }
}
