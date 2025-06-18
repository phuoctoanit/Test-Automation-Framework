package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ChallengeDetailPage extends WebBasePage {

    By titleField = By.id("title-display");
    By pointField = By.id("points-display");
    By descriptionField = By.id("description-display");

    public ChallengeDetailPage(WebDriver driver) {
        super(driver);
    }

    public void isLoaded(){

    }

    public void assertionTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement titleEle = wait.until(ExpectedConditions.visibilityOfElementLocated(titleField));
        Assert.assertEquals(titleEle.getText(), title, "Challenge title not matched");
    }

    public void assertionPoint(int point) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement pointEle = wait.until(ExpectedConditions.visibilityOfElementLocated(pointField));
        Assert.assertEquals(pointEle.getText(), String.valueOf(point), "Challenge points not matched");
    }

    public void assertionDescription(String description) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement descriptionEle = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionField));
        Assert.assertTrue(descriptionEle.getText().contains(description), "Challenge description not matched");
    }
}
