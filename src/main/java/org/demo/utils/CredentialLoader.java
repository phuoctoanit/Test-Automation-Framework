package org.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class CredentialLoader {

    private static final Properties credentialProperties = new Properties();

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("env/credentials.properties")) {
            if (input == null) {
                throw new RuntimeException("Missing file: env/credentials.properties. Check src/main/resources.");
            }
            credentialProperties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    public static String getCredential(String key) {
        String env = System.getProperty("env", "qa").toUpperCase();
        String isHeadless = System.getProperty("headless", "true").toUpperCase(Locale.ROOT);

        String envKey = env + "_" + key.toUpperCase(Locale.ROOT);
        Logger.info("Looking for credential key: " + envKey);

        String value = "";
        //First check on CI/CD
        if(Boolean.parseBoolean(isHeadless)) {
            value = System.getenv(envKey);
            Logger.info("Found in environment variables: " + value);
            if(value != null && !value.isEmpty()){
                return value;
            }
        }else {
            Logger.info("Not found in environment variables, checking properties file...");
            // Fallback to .properties file (local)
            value = credentialProperties.getProperty(envKey);
            if (value != null) {
                return value;
            }
        }


        throw new RuntimeException("Credential not found for key: " + envKey);
    }
}
