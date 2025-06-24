package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebBasePage {

    // Locators should be private and final
    private final By usernameField = By.id("identifier");
    private final By passwordField = By.id("password");
    private final By loginButton   = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        Logger.info("Input username and password");
        super.sendKeys(usernameField, userName);
        super.sendKeys(passwordField, password);
        super.click(loginButton);
    }
}
