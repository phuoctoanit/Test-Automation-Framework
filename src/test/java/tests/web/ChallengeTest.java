package tests.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.demo.models.Challenge;
import org.demo.pages.webapp.challenge.ChallengeCreationPage;
import org.demo.pages.webapp.challenge.ChallengeDetailPage;
import org.demo.pages.webapp.DashboardPage;
import org.demo.pages.webapp.challenge.MyChallengePage;
import org.demo.utils.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import providers.ChallengeDataProvider;

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
        challengeCreationPage.createChallenge(challenge);
        //Then should redirect to newly created challenge details
        Logger.info("Validation challenge in detail page");
        challengeDetailPage.assertionTitle(challenge.getTitle());
        challengeDetailPage.assertionPoint(challenge.getPoint());
        challengeDetailPage.assertionDescription(challenge.getDescription());

        // And should be displayed in the dashboard
        dashboardPage.openMyChallenge();
        myChallengePage.verifyNewlyCreatedChallenge(challenge);
    }
}
