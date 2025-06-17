package org.demo.pages;

import org.demo.base.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebBasePage {

    private WebElement userNameEle;
    private WebElement passwordEle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
