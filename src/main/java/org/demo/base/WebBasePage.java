package org.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class WebBasePage {

    protected WebDriver driver;

    public WebBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertUrlContains(String fragment) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlContains(fragment));
        Assert.assertTrue(driver.getCurrentUrl().contains(fragment),
                "Expected URL to contain: " + fragment + " but was: " + driver.getCurrentUrl());
    }
}
