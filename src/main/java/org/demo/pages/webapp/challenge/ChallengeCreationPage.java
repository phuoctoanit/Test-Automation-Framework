package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.demo.models.Challenge;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChallengeCreationPage extends WebBasePage {

    private final By titleField = By.id("title");
    private final By flagField = By.id("flag");
    private final By descriptionField = By.id("flask-pagedown-description");
    private final By attachFileField = By.id("file-upload");
    private final By categoryField = By.id("category");
    private final By pointField = By.id("points");
    private final By howToSolveField = By.id("howtosolve");
    private final By submitField = By.xpath("//button[@type='submit']");

    public ChallengeCreationPage(WebDriver driver) {
        super(driver);
    }

    public void createChallenge(Challenge challenge) {
        Logger.info("Creating challenge: " + challenge.getTitle());
        this.sendKeys(titleField, challenge.getTitle());
        this.sendKeys(flagField, challenge.getFlag());
        this.sendKeys(descriptionField, challenge.getDescription());
        if(challenge.getAttach() != null && !challenge.getAttach().trim().isEmpty()) {
            this.sendKeys(attachFileField, challenge.getAttach());
        }
        this.selectItemByVisibleText(categoryField, challenge.getCategory());
        this.selectItemByVisibleText(pointField, String.valueOf(challenge.getPoint()));
        this.sendKeys(howToSolveField, challenge.getHowToSolve());
        this.click(submitField);
    }
}
