package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {
    private static final Logger logger = LoggerFactory.getLogger(Screenshot.class);

    public static void saveScreenshot(WebDriver driver, String filename) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Path dir = Paths.get("target", "screenshot");
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }

            Path filePath = dir.resolve(filename);
            Files.write(filePath, screenshot);

            logger.info("Screenshot salvo em: {}", filePath.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Erro ao salvar screenshot: {}", filename, e);
        }
    }
}
