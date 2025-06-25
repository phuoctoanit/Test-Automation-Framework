package org.demo.pages.mobile.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.demo.base.IOSBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;

public class IOSWelcomePage extends IOSBasePage {

    private final By newReminderButton = By.xpath("//XCUIElementTypeButton[@name='New Reminder']");
    private final By titleInput = AppiumBy.accessibilityId("Quick Entry Title Field");
    private final By nodeInput = AppiumBy.accessibilityId("Notes text view");
    private final By addButton = AppiumBy.accessibilityId("Add");

    // Define any locators or elements specific to the iOS home page
    public IOSWelcomePage(IOSDriver driver) {
        super(driver);
    }

    public void goToSummaryPage() {
        // Example test method
        Logger.info("Clicking on the create new Reminder.");
        this.click(newReminderButton);
    }

    public void createNewReminder(String title, String node) {
        Logger.info("Create new Reminder.");
        this.sendKeys(titleInput, title);
        this.sendKeys(nodeInput, node);
        this.click(addButton);

        // Verify that the reminder was created successfully, back to the home page
        //WebElement newReminder = wait.until(d -> d.findElement(newReminderButton));
        //Assert.assertTrue(newReminder.isDisplayed(), "New Reminder button should be displayed after creating a reminder.");

    }
}
