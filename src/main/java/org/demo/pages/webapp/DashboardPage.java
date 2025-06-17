package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends WebBasePage {
    private final By challengeArrowIconField = By.xpath("//a[contains(@class, 'dropdown-toggle-split')]");
    private final By createChallengeItemFiled = By.xpath("//a[contains(@href, '/challenge/create')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void openChallengeCreation() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement challengeItemEle = wait.until(ExpectedConditions.elementToBeClickable(challengeArrowIconField));
        challengeItemEle.click();

        WebElement challengeCreationItemEle = wait.until(ExpectedConditions.elementToBeClickable(createChallengeItemFiled));
        challengeCreationItemEle.click();

        assertUrlContains("/challenge/create");
    }
}