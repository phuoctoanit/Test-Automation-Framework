package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.demo.models.Challenge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class MyChallengePage extends WebBasePage {

    By challengeCardsFields = By.xpath("//div[contains(@class, 'challenge-card')]");
    By challengeTitleField = By.xpath(".//div[contains(@class, 'card-header')]/span");
    By challengePointField = By.xpath(".//div[contains(@class, 'card-body')]//i[contains(@class, 'fa-fire-alt')]//following-sibling::span");
    By challengeStatusField = By.xpath(".//div[contains(@class, 'card-header')]/div/span");
    By challengeCategoryField = By.xpath(".//div[contains(@class, 'card-footer')]//span[@id='category-display']");
    By challengeCreatedByField = By.xpath(".//div[contains(@class, 'card-footer')]//span[2]");

    public MyChallengePage(WebDriver driver) {
        super(driver);
    }

    public void verifyNewlyCreatedChallenge(Challenge challenge) {
        //Wait for the page to load
        List<WebElement> challengeCardElse = driver.findElements(challengeCardsFields);
        Assert.assertFalse(challengeCardElse.isEmpty(), "There are at least a challenge after creating");
       // WebElement actualChallenge = challengeCardElse.get(0);

        Optional<WebElement> matchedCard = challengeCardElse.stream()
                .filter(card -> card.findElement(challengeTitleField).getText().equals(challenge.getTitle()))
                .findFirst();
        Assert.assertTrue(matchedCard.isPresent(), "Matching challenge card not found");
        WebElement actualChallenge = matchedCard.orElseThrow(() ->
                new AssertionError("Challenge card with title '" + challenge.getTitle() + "' not found"));
        //Compare challenge title
        WebElement headerEle = actualChallenge.findElement(challengeTitleField);
        Assert.assertEquals(headerEle.getText(), challenge.getTitle(), "Challenge title should match the created challenge title");
        //Compare challenge point
        WebElement pointEle = actualChallenge.findElement(challengePointField);
        Assert.assertEquals(pointEle.getText(), String.valueOf(challenge.getPoint()), "Challenge point should match the created challenge point");
        //Compare status
        WebElement statusEle = actualChallenge.findElement(challengeStatusField);
        Assert.assertEquals(statusEle.getText(), challenge.getStatus(), "Challenge status should match the created challenge status");
        //Compare created by
        WebElement createdByEle = actualChallenge.findElement(challengeCreatedByField);
        Assert.assertEquals(createdByEle.getText(), challenge.getCreatedBy(), "Challenge created by should match the created challenge created by");
        //Compare category
        WebElement categoryEle = actualChallenge.findElement(challengeCategoryField);
        Assert.assertEquals(categoryEle.getText(), challenge.getCategory(), "Category should match the created challenge category");
    }
}
