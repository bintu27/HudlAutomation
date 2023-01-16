package com.test.hudl.utils;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {
    static Properties prop = new Properties();

    /**************************************************************************************************
     Function to load properties files based on machine OS
     **************************************************************************************************/
    public static void loadProperties() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String confPath, msgPath, urlPath, userPath;

            if (os.startsWith("win")) {
                confPath = "\\src\\test\\resources\\config.properties";
                msgPath = "\\src\\test\\resources\\messages.properties";
                urlPath = "\\src\\test\\resources\\url.properties";
                userPath = "\\src\\test\\resources\\user.properties";
            } else {
                confPath = "/src/test/resources/config.properties";
                msgPath = "/src/test/resources/messages.properties";
                urlPath = "/src/test/resources/url.properties";
                userPath = "/src/test/resources/user.properties";
            }
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + confPath));
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + msgPath));
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + urlPath));
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + userPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }
}
