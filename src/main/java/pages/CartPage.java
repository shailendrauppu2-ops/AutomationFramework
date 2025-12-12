package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Abstraction {

    WebDriver driver;

    By checkoutBtn = By.cssSelector(".totalRow button");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkout() {
        driver.findElement(checkoutBtn).click();
    }
}
