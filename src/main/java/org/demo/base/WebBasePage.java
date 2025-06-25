package org.demo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

/**
 *
 */
public abstract class WebBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean urlContains(String fragment) {
        wait.until(ExpectedConditions.urlContains(fragment));
        return Objects.requireNonNull(driver.getCurrentUrl()).contains(fragment);
    }

    public void selectItemByVisibleText(By by, String item) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        Select select = new Select(element);
        select.selectByVisibleText(item);
    }

    public void waitForPageLoaded() {
        wait.until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));
    }

    /**
     *
     * @param by by locator for the element
     * @param text text to be sent to the element
     */
    public void sendKeys(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.clear();
        element.sendKeys(text);
    }

    /**
     *
     * @param by by locator for the element
     */
    public void click(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
}
