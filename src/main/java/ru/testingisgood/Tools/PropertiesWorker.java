package ru.testingisgood.Tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWorker {

    private static final String PROPERTIES_PATH = "src/test/resources/conf.properties";

    public static Properties readProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
