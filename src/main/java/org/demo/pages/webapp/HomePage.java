package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends WebBasePage {

    private final By loginHrefField = By.xpath("//li[contains(@class, 'nav-item')]//a[@href='/user/login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        //WebElement loginHref = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHrefField));
        WebElement loginHref = wait.until(ExpectedConditions.elementToBeClickable(loginHrefField));
        loginHref.click();
    }
}
