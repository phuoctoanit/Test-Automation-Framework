package org.demo.managers;

import org.demo.pages.webapp.*;
import org.demo.pages.webapp.challenge.ChallengeCreationPage;
import org.demo.pages.webapp.challenge.ChallengeDetailPage;
import org.demo.pages.webapp.challenge.MyChallengePage;
import org.openqa.selenium.WebDriver;

public class WebPageManager {

    private final WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ChallengeCreationPage challengeCreationPage;
    private ChallengeDetailPage challengeDetailPage;
    private MyChallengePage myChallengePage;

    public WebPageManager(WebDriver driver) { this.driver = driver; }

    public HomePage getHomePage(){
        if(this.homePage == null) {
            this.homePage = new HomePage(this.driver);
        }
        return this.homePage;
    }

    public LoginPage getLoginPage() {
        if(this.loginPage == null) {
            this.loginPage = new LoginPage(this.driver);
        }
        return this.loginPage;
    }

    public DashboardPage getDashboardPage() {
        if(this.dashboardPage == null) {
            this.dashboardPage = new DashboardPage(this.driver);
        }
        return this.dashboardPage;
    }

    public ChallengeCreationPage getChallengeCreation() {
        if(this.challengeCreationPage == null) {
            this.challengeCreationPage = new ChallengeCreationPage(this.driver);
        }
        return this.challengeCreationPage;
    }

    public ChallengeDetailPage getChallengeDetailPage() {
        if(this.challengeDetailPage == null) {
            this.challengeDetailPage = new ChallengeDetailPage(this.driver);
        }
        return this.challengeDetailPage;
    }

    public MyChallengePage getMyChallengePage() {
        if(this.myChallengePage == null) {
            this.myChallengePage = new MyChallengePage(driver);
        }
        return this.myChallengePage;
    }
}
