package org.demo.pages.mobile.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.demo.base.IOSBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class IOSWelcomePage extends IOSBasePage {


    By newReminderButton = By.xpath("//XCUIElementTypeButton[@name='New Reminder']");
    By titleInput = AppiumBy.accessibilityId("Quick Entry Title Field");
    By nodeInput = AppiumBy.accessibilityId("Notes text view");
    By addButton = AppiumBy.accessibilityId("Add");

    // Define any locators or elements specific to the iOS home page
    public IOSWelcomePage(IOSDriver driver) {
        super(driver);
    }

    public void goToSummaryPage() {
        // Example test method
        Logger.info("Clicking on the creae new Reminder.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement newReminder = wait.until(d -> d.findElement(newReminderButton));
        newReminder.click();
    }

    public void createNewReminder(String title, String node) {
        Logger.info("Create new Reminder.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement titleField = wait.until(d -> d.findElement(titleInput));
        titleField.sendKeys(title);

        WebElement nodeField = wait.until(d -> d.findElement(nodeInput));
        nodeField.sendKeys(node);

        WebElement addBtn = wait.until(d -> d.findElement(addButton));
        addBtn.click();

        // Verify that the reminder was created successfully, back to the home page
        WebElement newReminder = wait.until(d -> d.findElement(newReminderButton));
        Assert.assertTrue(newReminder.isDisplayed(), "New Reminder button should be displayed after creating a reminder.");

    }
}
