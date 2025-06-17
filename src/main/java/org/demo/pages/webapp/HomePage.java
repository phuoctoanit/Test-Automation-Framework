package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends WebBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        Logger.info("Navigate to Login Page");
        WebElement loginHref = driver.findElement(By.xpath("//li[contains(@class, 'nav-item')]//a[@href='/user/login']"));
        loginHref.click();
    }
}
