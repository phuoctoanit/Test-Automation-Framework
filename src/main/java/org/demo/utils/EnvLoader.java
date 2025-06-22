package org.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvLoader {
    private static final Properties properties = new Properties();

    public static void load(String env) {
        try (InputStream input = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("env/" + env + ".properties")) {
            if (input == null) {
                throw new RuntimeException("Config file not found for env: " + env);
            }
            properties.load(input);
        } catch (IOException ex) {
            Logger.error("Error loading config file for env: " + env + " - " + ex.getMessage());
            throw new RuntimeException("Failed to load config for: " + env);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
