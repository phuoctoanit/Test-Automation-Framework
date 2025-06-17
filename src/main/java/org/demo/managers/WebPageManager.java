package org.demo.managers;

import org.demo.pages.webapp.DashboardPage;
import org.demo.pages.webapp.HomePage;
import org.demo.pages.webapp.LoginPage;
import org.openqa.selenium.WebDriver;

public class WebPageManager {

    private final WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

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
            this.dashboardPage = new DashboardPage(driver);
        }
        return this.dashboardPage;
    }
}
