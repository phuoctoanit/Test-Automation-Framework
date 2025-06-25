package org.demo.utils;

import org.demo.drivers.mobile.PlatformType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CapabilitiesLoader {

    private static String getCapabilitiesPath(PlatformType platform) {
        switch (platform) {
            case ANDROID:
                return "src/main/resources/capabilities/android_capabilities.xml"; // Update with your Android capabilities file path
            case IOS:
                return "src/main/resources/capabilities/ios_capabilities.xml"; // Update with your iOS capabilities file path
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }


    private static Document loadXmlDocument(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("Capabilities file not found: " + path);
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc =  builder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static String getURL(PlatformType platform) {
        try{
            String path = getCapabilitiesPath(platform);
            Document doc = loadXmlDocument(path);
            NodeList capList = doc.getElementsByTagName("url");
            if (capList.getLength() == 0) {
                Logger.error("No URL found in capabilities file: " + path);
                return "";
            }
            Node node = capList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String url = element.getTextContent().trim();
                if (url.isEmpty()) {
                    Logger.error("URL is empty in capabilities file: " + path);
                    return "";
                }
                return url;
            } else {
                Logger.error("URL node is not an element in capabilities file: " + path);
                return "";
            }
        }catch (Exception e){
            Logger.error("Failed to get URL from capabilities: " + e.getMessage());
        }
        return "";
    }

    public static DesiredCapabilities getCapability(PlatformType platform) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            String path = getCapabilitiesPath(platform);
            Document doc = loadXmlDocument(path);
            NodeList capList = doc.getElementsByTagName("capability");
            for (int i = 0; i < capList.getLength(); i++) {
                Node node = capList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getAttribute("name");
                    String value = element.getAttribute("value");
                    String active = element.getAttribute("active");
                    if ("false".equalsIgnoreCase(active)) {
                        Logger.debug("Skipping inactive capability: " + name);
                        continue;
                    }
                    if(name.equalsIgnoreCase("appium:app")) {
                        if (!value.isEmpty()) {
                            value = new File(System.getProperty("user.dir") + value).getAbsolutePath();
                        } else {
                            Logger.error("App path is empty for capability: " + name);
                        }
                    }
                    capabilities.setCapability(name, parseValue(value));
                }
            }
        } catch (Exception e) {
            Logger.error("Failed to load capabilities from XML: " + e.getMessage());
        }
        return capabilities;
    }

    private static Object parseValue(String value) {
        if ("true".equalsIgnoreCase(value)) return true;
        if ("false".equalsIgnoreCase(value)) return false;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Not an integer, return as string
        }
        return value;
    }
}
