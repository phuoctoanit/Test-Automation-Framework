package tests.web;

import org.demo.drivers.WebDriverFactory;
import org.demo.managers.WebPageManager;
import org.demo.utils.EnvLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
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
    }

    @AfterSuite
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
