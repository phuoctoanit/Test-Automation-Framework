package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChallengeDetailPage extends WebBasePage {

    By titleField = By.id("title-display");
    By pointField = By.id("points-display");
    By descriptionField = By.id("description-display");

    public ChallengeDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleField)).isDisplayed();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleField)).getText();
    }

    public int getPoint() {
        String pointText = wait.until(ExpectedConditions.visibilityOfElementLocated(pointField)).getText();
        return Integer.parseInt(pointText.replaceAll("[^0-9]", ""));
    }

    public String getDescription() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionField)).getText();
    }
}
