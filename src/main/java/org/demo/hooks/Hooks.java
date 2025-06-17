package org.demo.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.demo.managers.WebPageManager;
import org.demo.utils.Logger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private WebPageManager webPageManager;

    @Before
    public void setUp(Scenario scenario) {
        Logger.info("--Starting scenario: " + scenario.getName());
    }

    public void tearDown(Scenario scenario) {
        Logger.info("--Complete scenario: " + scenario.getName());
    }
}
