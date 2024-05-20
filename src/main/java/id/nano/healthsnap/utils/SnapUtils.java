package id.nano.healthsnap.utils;

import id.nano.healthsnap.config.AtmConfig;
import id.nano.healthsnap.config.Config;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SnapUtils {

    public void runSnap(Config Config) throws IOException {
        // Start stopwatch
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // Directory setup
        String dir = "./result/Res/Maret/ATM/DC/";
        FileUtils.createDirectories(dir);

        PrintWriter printWriter = FileUtils.getPrintWriter(dir + "URLTaken.txt");

        // WebDriver setup
        WebDriver driver = WebUtils.setupWebDriver(Config);

        // Process services
        processServices(Config, driver, printWriter, "JDBC", Config.DATASOURCE_SERVICES);
        processServices(Config, driver, printWriter, "Host", Config.HOST_SERVICES);
        processServices(Config, driver, printWriter, "Core", Config.CORE_SERVICES);

        // Cleanup
        driver.quit();
        printWriter.close();

        // Stop stopwatch and print elapsed time
        stopWatch.stop();
        System.out.println("Time Elapsed : " + stopWatch.getTime(TimeUnit.MINUTES) + " Minutes");
    }

    private void processServices(Config Config, WebDriver driver, PrintWriter printWriter, String category, List<String> services) throws IOException {
        for (Integer i = 20; i <= 21; i++) {
            String date = "2024-03-" + String.format("%02d", i);

            for (String service : services) {
                String url = Config.BASE_URI + category.toLowerCase() + "/" + service + ".png?datetime=" + date + Config.MISC;
                WebUtils.takeScreenshot(driver, url, "./result/Res/Maret/ATM/DC/" + category + "/" + service + "_" + date + ".png");
                System.out.println(url + " taken");
                printWriter.println(url);
            }
        }
    }
}
