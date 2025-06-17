package tests.web;

import io.cucumber.java.Before;
import org.demo.drivers.TestSession;
import org.demo.drivers.WebDriverFactory;
import org.demo.managers.WebPageManager;
import org.demo.utils.EnvLoader;
import org.demo.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;
    protected WebPageManager webPageManager;

    @BeforeSuite
    public void setup() {
        String browser = System.getProperty("browser", "chrome"); // fallback default
        String env = System.getProperty("env", "qa");

        //Loading environment
        EnvLoader.load(env);
        //Init web driver at before suite
        WebDriverFactory.setBrowserName(browser);
        WebDriverFactory.initWebDriver();

        this.driver = WebDriverFactory.getDriver();
        this.webPageManager = new WebPageManager(this.driver);

        TestSession.setDriver(this.driver);
        TestSession.setWebPageManager(this.webPageManager);

        Logger.info("Executing suite on environment: " + env.toUpperCase() + " and browser: " + browser.toUpperCase());
    }

    @AfterSuite
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    @BeforeClass
    public void initSession() {
        this.driver = TestSession.getDriver();
        this.webPageManager = TestSession.getWebPageManager();

        if (this.driver == null || this.webPageManager == null) {
            throw new RuntimeException("Test session not initialized. Ensure @BeforeSuite ran correctly.");
        }
    }
}
