package pages;

import driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class Abstraction {

    WebDriver driver;

    public Abstraction(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        WaitUtils.waitForClick(element);
        element.click();
    }

    public void type(WebElement element, String value) {
        WaitUtils.waitForVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public void waitForElement(By locator) {
        WaitUtils.waitForPresence(locator);
    }

    public void waitForDisappear(WebElement element) {
        WaitUtils.waitForDisappear(element);
    }
}
