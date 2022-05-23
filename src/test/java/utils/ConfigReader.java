package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static Properties readProperties(String filePath) {
        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getPropertyValue (String key) {
        return properties.getProperty(key);
    }
}
