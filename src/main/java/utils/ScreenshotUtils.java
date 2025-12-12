package utils;

import driverfactory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String capture(String testName) {
        File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

        String filePath = "screenshots/" + testName + "_" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";

        File dest = new File(filePath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
