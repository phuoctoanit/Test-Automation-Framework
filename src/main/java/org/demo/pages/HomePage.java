package org.demo.pages;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends WebBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        WebElement loginHref = webDriver.findElement(By.xpath("//li[contains(@class, 'nav-item')]//a[@href='/user/login']"));
        loginHref.click();
    }
}
