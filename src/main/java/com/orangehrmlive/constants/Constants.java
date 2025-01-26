package com.orangehrmlive.constants;

public final class Constants {

    private Constants() {}

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    public static String getConfigFilePath() { return CONFIG_FILE_PATH; }
}
