package id.nano.healthsnap.utils;

import id.nano.healthsnap.config.AtmConfig;
import id.nano.healthsnap.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class WebUtils {
    public static WebDriver setupWebDriver(Config config) {
        WebDriver driver = new ChromeDriver();
        Predicate<URI> uriPredicate = uri -> uri.toString().contains(config.IP);
        Supplier<Credentials> authentication = UsernameAndPassword.of(config.USERNAME, config.PASSWORD);
        ((HasAuthentication) driver).register(uriPredicate, authentication);
        return driver;
    }

    public static void takeScreenshot(WebDriver driver, String url, String outputPath) throws IOException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.tagName("img"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File(outputPath));
    }
}
