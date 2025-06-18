package org.demo.listeners;

import io.appium.java_client.AppiumDriver;
import org.demo.drivers.web.WebDriverSession;
import org.demo.utils.Logger;
import org.demo.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class MobileScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.info(">> onTestFailure called for: " + result.getName());
        attachScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info(">> onTestSkipped called for: " + result.getName());
        attachScreenshot(result); // Optional: for skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        attachScreenshot(result);
    }

    private void attachScreenshot(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            Field field = testClass.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            AppiumDriver driver = (AppiumDriver) field.get(testClass);
            if (driver != null) {
                ScreenshotUtil.captureScreenshot(driver, "Failure Screenshot");
            } else {
                Logger.warn("Driver was null in test instance: " + testClass.getClass().getName());
            }

        } catch (Exception e) {
            Logger.error("Exception during screenshot: " + e.getMessage());
        }
    }

}
