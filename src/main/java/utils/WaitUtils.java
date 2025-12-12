package utils;

import driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout")))
        );
    }

    public static void waitForVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClick(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForDisappear(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }
}
