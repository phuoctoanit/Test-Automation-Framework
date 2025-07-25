package tests.web;

import io.qameta.allure.*;
import org.demo.pages.webapp.HomePage;
import org.demo.pages.webapp.LoginPage;
import org.demo.utils.CredentialLoader;
import org.demo.utils.EnvLoader;
import org.demo.utils.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        super.initSession();
        homePage = super.webPageManager.getHomePage();
        loginPage = super.webPageManager.getLoginPage();
    }

    @Test(description = "Valid login scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify login with valid credentials")
    @Story("User Story 1 (Web)")
    public void loginTest(){
        // Navigate to the login page and perform login
        Logger.info("Navigate to Login Page: " + EnvLoader.get("baseURL"));
        Allure.step("Navigate to Login Page: " + EnvLoader.get("baseURL"));
        String url = EnvLoader.get("baseURL");
        this.driver.get(url);
        homePage.navigateToLoginPage();
        String username = CredentialLoader.getCredential("username");
        String password = CredentialLoader.getCredential("password");
        Allure.step("Perform login with username: *** and password: ***");
        loginPage.login(username, password);
        Allure.step("Assert that the user is redirected to the dashboard after login");
        Assert.assertTrue(loginPage.urlContains("/dashboard"), "URL does not contain '/dashboard'");
    }
}
