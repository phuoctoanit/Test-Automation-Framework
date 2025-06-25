package org.demo.base;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IOSBasePage {

    protected IOSDriver driver;
    protected WebDriverWait wait;

    public IOSBasePage(IOSDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Adjust the timeout as needed
    }

    public void click(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void sendKeys(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.sendKeys(text);
    }
    // Include any common methods or properties that all iOS pages should have
}
