package tests.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.demo.pages.webapp.DashboardPage;
import org.demo.utils.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeClass
    public void initPages() {
        super.initSession();
        dashboardPage = super.webPageManager.getDashboardPage();
    }

    @Test(description = "Open the Challenge Creation page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Open the Challenge Creation page")
    @Story("User Story 1 (Web)")
    public void openChallengeCreationTest() {
        Logger.info("Open the Challenge Creation page");
        dashboardPage.openChallengeCreation();
    }
}
