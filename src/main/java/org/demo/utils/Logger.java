package org.demo.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Logger.class);

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }
}