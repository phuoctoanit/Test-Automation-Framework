package tests.web;

import org.demo.pages.webapp.DashboardPage;
import org.demo.pages.webapp.HomePage;
import org.demo.pages.webapp.LoginPage;
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

    @Test
    public void openChallengeCreation() {
        Logger.info("Open the Challenge Creation page");
        dashboardPage.openChallengeCreation();
    }
}
