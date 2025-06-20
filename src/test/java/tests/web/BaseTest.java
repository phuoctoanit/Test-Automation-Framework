package tests.web;

import org.demo.constants.Constants;
import org.demo.drivers.web.WebDriverSession;
import org.demo.drivers.web.WebDriverFactory;
import org.demo.managers.WebPageManager;
import org.demo.utils.EnvLoader;
import org.demo.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected WebPageManager webPageManager;

    @BeforeSuite
    public void setup() {
        String browser = System.getProperty("browser", Constants.DEFAULT_BROWSER); // fallback default
        String env = System.getProperty("env", Constants.DEFAULT_ENV);

        //Loading environment
        EnvLoader.load(env);
        //Init web driver at before suite
        WebDriverFactory.setBrowserName(browser);
        WebDriverFactory.initWebDriver();

        // Write environment info to Allure
        writeEnvironmentInfo(browser.toUpperCase(), env.toUpperCase(), EnvLoader.get("baseURL"));

        // Initialize WebDriver and WebPageManager
        this.driver = WebDriverFactory.getDriver();
        this.webPageManager = new WebPageManager(this.driver);

        WebDriverSession.setDriver(this.driver);
        WebDriverSession.setWebPageManager(this.webPageManager);

        Logger.info("Executing suite on environment: " + env.toUpperCase() + " and browser: " + browser.toUpperCase());
    }

    @AfterSuite
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    @BeforeClass
    public void initSession() {
        this.driver = WebDriverSession.getDriver();
        this.webPageManager = WebDriverSession.getWebPageManager();

        if (this.driver == null || this.webPageManager == null) {
            throw new RuntimeException("Test session not initialized. Ensure @BeforeSuite ran correctly.");
        }
    }

    private void writeEnvironmentInfo(String browser, String env, String baseURL) {
        Logger.info("Writing environment info to Allure: Browser=" + browser + ", Environment=" + env + ", BaseURL=" + baseURL);
        // Here you can implement the logic to write environment info to Allure reports
        // For example, using AllureEnvironmentWriter or similar utility
        // AllureEnvironmentWriter.writeEnvironmentInfo(browser, env, baseURL);
        try{
            Properties properties = new Properties();
            properties.setProperty("Browser", browser);
            properties.setProperty("Environment", env);
            properties.setProperty("BaseURL", baseURL);

            File resultDir = new File("allure-results");
            if(!resultDir.exists()) {
                resultDir.mkdirs();
            }

            File file = new File(resultDir, "environment.properties");
            try(FileWriter writer = new FileWriter(file)) {
                properties.store(writer, "Environment Info");
            }
        } catch (IOException e) {
            Logger.error("Failed to write environment info: " + e.getMessage());
        }
    }
}
