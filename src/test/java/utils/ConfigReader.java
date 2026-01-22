package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    private static Properties properties;
    private static final Logger LOGGER = Logger.getLogger(ConfigReader.class.getName());

    // Bloco estático para carregar o arquivo uma vez
    static {
        try {
            String path = "src/test/resources/config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Falha ao carregar o arquivo config.properties", e);
            throw new RuntimeException("Falha ao carregar o arquivo config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
