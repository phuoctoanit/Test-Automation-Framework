package tests.web;

import org.demo.pages.webapp.HomePage;
import org.demo.pages.webapp.LoginPage;
import org.demo.utils.CredentialLoader;
import org.demo.utils.EnvLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        homePage = super.webPageManager.getHomePage();
        loginPage = super.webPageManager.getLoginPage();
    }

    @Test
    public void loginTest(){
        String url = EnvLoader.get("baseURL");
        this.driver.get(url);
        homePage.navigateToLoginPage();
        String username = CredentialLoader.getCredential("username");
        String password = CredentialLoader.getCredential("password");
        loginPage.login(username, password);
        loginPage.assertUrlContains("/dashboard");
    }
}
