package org.demo.base;

import org.openqa.selenium.WebDriver;

public abstract class WebBasePage {

    protected WebDriver webDriver;

    public WebBasePage(WebDriver driver) {
        this.webDriver = driver;
    }
}
