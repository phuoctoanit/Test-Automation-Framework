package org.demo.managers;

import org.demo.pages.DashboardPage;
import org.demo.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class WebPageManager {

    private final WebDriver driver;
    private HomePage homePage;
    private DashboardPage dashboardPage;

    public WebPageManager(WebDriver driver) { this.driver = driver; }

    public HomePage getHomePage(){
        if(this.homePage == null) {
            this.homePage = new HomePage(this.driver);
        }
        return this.homePage;
    }
}
