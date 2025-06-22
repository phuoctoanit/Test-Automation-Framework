package org.demo.drivers.mobile.managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.demo.drivers.mobile.PlatformType;
import org.demo.drivers.mobile.implement.MobileDriverImplement;
import org.demo.utils.CapabilitiesLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSDriverManager implements MobileDriverImplement {

    @Override
    public AppiumDriver createDriver() throws Exception {
        DesiredCapabilities caps = CapabilitiesLoader.getCapability(PlatformType.IOS);

        //Only work on simulator, to set permissions for the app, and need install
        //brew tap wix/brew
        //brew install applesimutils

        String permissionsJson = "{"
            + "\"com.apple.Fitness\": {"
            +     "\"camera\": \"YES\","
            +     "\"contacts\": \"YES\","
            +     "\"location\": \"yes\""
            + "}"
            + "}";
        caps.setCapability("appium:permissions", permissionsJson);

        //Open welcome screen
        Map<String, Object> processArgs = new HashMap<>();
        processArgs.put("args", List.of("--openWelcomeScreen")); // CLI-style args
        processArgs.put("env", Map.of("UITEST_MODE", "true"));   // Optional env vars

        caps.setCapability("appium:processArguments", processArgs);

        return new IOSDriver(new URL(CapabilitiesLoader.getURL(PlatformType.IOS)), caps);
    }
}
