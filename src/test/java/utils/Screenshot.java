package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Screenshot {
    public static void saveScreenshot(WebDriver driver, String filename) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            String path = "src/test/resources/screenshot/";
            Files.write(Paths.get(path + filename), screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
