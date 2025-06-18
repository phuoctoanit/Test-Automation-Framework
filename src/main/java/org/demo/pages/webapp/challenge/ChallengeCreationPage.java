package org.demo.pages.webapp.challenge;

import org.demo.base.WebBasePage;
import org.demo.models.Challenge;
import org.demo.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ChallengeCreationPage extends WebBasePage {

    By titleField = By.id("title");
    By flagField = By.id("flag");
    By descriptionField = By.id("flask-pagedown-description");
    By attachFileField = By.id("file-upload");
    By categoryField = By.id("category");
    By pointField = By.id("points");
    By howToSolveField = By.id("howtosolve");
    By submitField = By.xpath("//button[@type='submit']");

    public ChallengeCreationPage(WebDriver driver) {
        super(driver);
    }

    public void createChallenge(Challenge challenge) {
        WebElement titleEle = driver.findElement(titleField);
        titleEle.clear();
        titleEle.sendKeys(challenge.getTitle());

        Logger.debug(titleEle.getText());

        WebElement flagEle = driver.findElement(flagField);
        flagEle.clear();
        flagEle.sendKeys(challenge.getFlag());

        WebElement descriptionEle = driver.findElement(descriptionField);
        descriptionEle.clear();
        descriptionEle.sendKeys(challenge.getDescription());

        if(!Objects.equals(challenge.getAttach().trim(), "")) {
            WebElement attachEle = driver.findElement(attachFileField);
            attachEle.sendKeys(challenge.getAttach());
        }

        WebElement categoryEle = driver.findElement(categoryField);
        selectItemByVisibleText(categoryEle, challenge.getCategory());

        WebElement pointEle = driver.findElement(pointField);
        selectItemByVisibleText(pointEle, String.valueOf(challenge.getPoint()));

        WebElement howToSolveEle = driver.findElement(howToSolveField);
        howToSolveEle.sendKeys(challenge.getHowToSolve());

        WebElement submitBtn = driver.findElement(submitField);
        submitBtn.click();
    }
}
