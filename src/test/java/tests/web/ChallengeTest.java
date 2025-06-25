package tests.web;

import io.qameta.allure.*;
import org.demo.models.Challenge;
import org.demo.pages.webapp.challenge.ChallengeCreationPage;
import org.demo.pages.webapp.challenge.ChallengeDetailPage;
import org.demo.pages.webapp.DashboardPage;
import org.demo.pages.webapp.challenge.MyChallengePage;
import org.demo.utils.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import providers.ChallengeDataProvider;
import java.util.Optional;

public class ChallengeTest extends BaseTest{

    private ChallengeCreationPage challengeCreationPage;
    private ChallengeDetailPage challengeDetailPage;
    private DashboardPage dashboardPage;
    private MyChallengePage myChallengePage;

    @BeforeClass
    public void initPages() {
        super.initSession();
        dashboardPage = super.webPageManager.getDashboardPage();
        challengeCreationPage = super.webPageManager.getChallengeCreation();
        challengeDetailPage = super.webPageManager.getChallengeDetailPage();
        myChallengePage = super.webPageManager.getMyChallengePage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Create a new challenge and verify its details")
    @Story("User Story 1 (Web)")
    @Test(description = "Create a new challenge and verify its details", dataProvider = "challengeData", dataProviderClass = ChallengeDataProvider.class)
    public void createChallengeTest(Challenge challenge) {
        Logger.info("Create challenge with title: " + challenge.getTitle());
        Allure.step("Create challenge with title: " + challenge.getTitle());
        challengeCreationPage.createChallenge(challenge);
        //Then should redirect to newly created challenge details
        Logger.info("Validation challenge in detail page");
        Allure.step("Validate challenge in detail page:");
        Allure.step("-- Validate challenge title");
        Assert.assertEquals(challengeDetailPage.getTitle(), challenge.getTitle(), "Challenge title does not match");
        Allure.step("-- Validate challenge point");
        Assert.assertEquals(challengeDetailPage.getPoint(), challenge.getPoint(), "Point does not match");
        Allure.step("-- Validate challenge description");
        Assert.assertEquals(challengeDetailPage.getDescription(), challenge.getDescription(), "Description does not match");

        // And should be displayed in the dashboard
        Logger.info("Open My Challenge page to verify the newly created challenge");
        Allure.step("Open My Challenge page to verify the newly created challenge");
        dashboardPage.openMyChallenge();
        Allure.step("Verify newly created challenge in My Challenge page");
        Assert.assertTrue(dashboardPage.urlContains("/challenge/by/"), "URL does not contain '/challenge/by/'");
        dashboardPage.waitForPageLoaded();

        Allure.step("Validate challenge in My Challenge page:");
        Allure.step("-- Validate challenge title");
        Optional<WebElement> cartOpt = myChallengePage.findChallengeCardByTitle(challenge.getTitle());
        Assert.assertTrue(cartOpt.isPresent(), "Challenge card with title '" + challenge.getTitle() + "' not found in My Challenge page");

        WebElement cart = cartOpt.get();
        Assert.assertEquals(myChallengePage.getChallengeTitle(cart), challenge.getTitle(), "Challenge title in My Challenge page does not match");

        Allure.step("-- Validate challenge point");
        Assert.assertEquals(myChallengePage.getChallengePoint(cart), challenge.getPoint(), "Challenge point in My Challenge page does not match");

        Allure.step("-- Validate challenge status");
        Assert.assertEquals(myChallengePage.getChallengeStatus(cart), challenge.getStatus(), "Challenge status in My Challenge page does not match");

        Allure.step("-- Validate challenge category");
        Assert.assertEquals(myChallengePage.getChallengeCategory(cart), challenge.getCategory(), "Challenge category in My Challenge page does not match");

        Allure.step("-- Validate challenge created by");
        Assert.assertEquals(myChallengePage.getChallengeCreatedBy(cart), challenge.getCreatedBy(), "Challenge created by in My Challenge page does not match");
    }
}
