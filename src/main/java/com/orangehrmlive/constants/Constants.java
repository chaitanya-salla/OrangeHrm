package com.orangehrmlive.constants;

import java.util.concurrent.TimeUnit;

public final class Constants {

    private Constants() {}

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final int EXPLICIT_WAIT = 10;

    public static String getConfigFilePath() { return CONFIG_FILE_PATH; }
    public static int getExplicitWait() { return EXPLICIT_WAIT; }
}
