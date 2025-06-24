package org.demo.pages.webapp;

import org.demo.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends WebBasePage {
    private final By challengeArrowIconField = By.xpath("//a[contains(@class, 'dropdown-toggle-split')]");
    private final By createChallengeItemField = By.xpath("//a[contains(@href, '/challenge/create')]");
    private final By myChallengeItemField = By.xpath("//a[contains(@href, '/challenge/by/')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the challenge dropdown menu.
     * This method clicks on the challenge arrow icon to reveal the dropdown options.
     */
    private void openChallengeDropdown(){
        super.click(challengeArrowIconField);
    }

    /**
     * Opens the challenge dropdown menu.
     */
    public void openMyChallenge() {
        this.openChallengeDropdown();
        this.click(myChallengeItemField);
    }

    public void openChallengeCreation() {
        this.openChallengeDropdown();
        this.click(createChallengeItemField);
    }
}