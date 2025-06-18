package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        WebElement titleEle = driver.findElement(titleField);
        Assert.assertEquals(titleEle.getText(), title);
    }

    public void assertionPoint(int point) {
        WebElement pointEle = driver.findElement(pointField);
        Assert.assertEquals(pointEle.getText(), String.valueOf(point));
    }

    public void assertionDescription(String description) {
        WebElement descriptionEle = driver.findElement(descriptionField);
        Assert.assertTrue(descriptionEle.getText().contains(description));
    }
}
