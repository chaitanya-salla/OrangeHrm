package com.orangehrmlive.utils;

import com.orangehrmlive.enums.ConfigProperties;

import java.io.FileInputStream;

import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

import static com.orangehrmlive.constants.Constants.getConfigFilePath;

public final class PropertyUtils {

    private PropertyUtils() {}

    private static final HashMap<String, String> propertyMap = new HashMap<>();

    static {
        try(FileInputStream inputStream = new FileInputStream(getConfigFilePath())) {
            Properties prop = new Properties();
            prop.load(inputStream);
            prop.forEach((key, value) -> propertyMap.put((String)key, String.valueOf(value).trim()));
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while reading the property file.", e);
        }
    }

    public static String getProperty(ConfigProperties key) {

        if(Objects.isNull(key))
            throw new NullPointerException("Key is null. Please check.");

        String keyString = key.toString().toLowerCase();
        if(Objects.isNull(propertyMap.get(keyString)))
            throw new NullPointerException("Property - " + key + ", doesn't have value. Please check config.properties file.");
        return propertyMap.get(keyString);
    }
}
