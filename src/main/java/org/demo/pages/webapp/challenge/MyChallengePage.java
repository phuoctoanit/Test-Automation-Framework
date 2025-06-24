package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Optional;

public class MyChallengePage extends WebBasePage {

    private final By challengeCardsFields = By.xpath("//div[contains(@class, 'challenge-card')]");
    private final By challengeTitleField = By.xpath(".//div[contains(@class, 'card-header')]/span");
    private final By challengePointField = By.xpath(".//div[contains(@class, 'card-body')]//i[contains(@class, 'fa-fire-alt')]//following-sibling::span");
    private final By challengeStatusField = By.xpath(".//div[contains(@class, 'card-header')]/div/span");
    private final By challengeCategoryField = By.xpath(".//div[contains(@class, 'card-footer')]//span[@id='category-display']");
    private final By challengeCreatedByField = By.xpath(".//div[contains(@class, 'card-footer')]//span[2]");

    public MyChallengePage(WebDriver driver) {
        super(driver);
    }

    public Optional<WebElement> findChallengeCardByTitle(String title) {
        List<WebElement> challengeCards = wait.until(driver -> driver.findElements(challengeCardsFields));
        return challengeCards.stream()
                .filter(card -> card.findElement(challengeTitleField).getText().equals(title))
                .findFirst();
    }

    public String getChallengeTitle(WebElement challengeCard) {
        return challengeCard.findElement(challengeTitleField).getText();
    }

    public int getChallengePoint(WebElement challengeCard) {
        String pointText = challengeCard.findElement(challengePointField).getText();
        return Integer.parseInt(pointText);
    }

    public String getChallengeStatus(WebElement challengeCard) {
        return challengeCard.findElement(challengeStatusField).getText();
    }

    public String getChallengeCategory(WebElement challengeCard) {
        return challengeCard.findElement(challengeCategoryField).getText();
    }

    public String getChallengeCreatedBy(WebElement challengeCard) {
        return challengeCard.findElement(challengeCreatedByField).getText();
    }
}
