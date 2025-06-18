package org.demo.drivers;

import org.demo.utils.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> tlWedDriver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    private static final String GRID_URL = "http://localhost:4444/wd/hub";

    private static URL buildURL() throws MalformedURLException {
        return URI.create(GRID_URL).toURL();
    }

    public static void setBrowserName(String browser) {
        browserName.set(browser);
    }

    public static void initWebDriver() {
        WebDriver webDriver = null;
        String browser = browserName.get();
        if(browser == null) browser = "chrome";
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("browserName", "firefox");
                if (isCI()){
                    Logger.debug("Running on CI environment with headless and remote grid");
                    try{
                        firefoxOptions.addArguments("--headless=new");
                        firefoxOptions.addArguments("--window-size=1920,1080");
                        webDriver = new RemoteWebDriver(buildURL(), firefoxOptions);
                    }catch (MalformedURLException e) {
                        Logger.error("Exception occurred during process: " +  e);
                    }
                }else{
                    webDriver = new FirefoxDriver(firefoxOptions);
                }
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("browserName", "chrome");
                if (isCI()) {
                    Logger.debug("Running on CI environment with headless and remote grid");
                    try{
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--window-size=1920,1080");
                        webDriver = new RemoteWebDriver(buildURL(), chromeOptions);
                    }catch (MalformedURLException e) {
                        Logger.error("Exception occurred during process: " +  e);
                    }
                }else{
                    webDriver = new ChromeDriver(chromeOptions);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
        }
        tlWedDriver.set(webDriver);
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
    }

    public static WebDriver getDriver() {
        return  tlWedDriver.get();
    }

    public static String browserName() { return browserName.get(); }

    public static void quitDriver() {
        if(getDriver() != null) {
            getDriver().quit();
            tlWedDriver.remove();
        }
    }

    private static boolean isCI() {
        // Detect headless mode dynamically
        return Boolean.parseBoolean(System.getProperty("headless", "false"))
                || Boolean.parseBoolean(System.getenv("CI"));
    }
}
