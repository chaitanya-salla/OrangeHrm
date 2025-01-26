package com.orangehrmlive.utils;

import com.orangehrmlive.constants.Constants;

import java.io.FileInputStream;

import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

import static com.orangehrmlive.constants.Constants.getConfigFilePath;

public final class ReadPropertyFile {

    private ReadPropertyFile() {}

    private static final HashMap<String, String> propertyMap = new HashMap<>();

    static {
        try(FileInputStream inputStream = new FileInputStream(getConfigFilePath())) {
            Properties prop = new Properties();
            prop.load(inputStream);
            prop.forEach((key, value) -> propertyMap.put((String)key, (String)value));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while reading the property file.", e);
        }
    }

    public static String getProperty(String key) {

        if(Objects.isNull(key))
            throw new NullPointerException("Key is null. Please check.");

        if(Objects.isNull(propertyMap.get(key)))
            throw new NullPointerException("Property - " + key + ", doesn't have value. Please check config.properties file.");
        return propertyMap.get(key);
    }
}
