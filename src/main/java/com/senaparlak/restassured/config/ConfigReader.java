package com.senaparlak.restassured.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
        } catch (IOException e) {
                throw new RuntimeException("Config file could not be loaded", e);
        }
        }
        public static String getProperty(String key) {
        return properties.getProperty(key);
        }
    }

