package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebBasePage {

    private final By loginHrefField = By.xpath("//li[contains(@class, 'nav-item')]//a[@href='/user/login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        Logger.info("Navigating to the login page");
        super.click(loginHrefField);
    }
}
