package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Abstraction {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryBox;

    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement selectCountry;

    @FindBy(css = ".action__submit")
    WebElement placeOrderBtn;

    public void fillDetails(String country) {
        type(countryBox, country);
        click(selectCountry);
    }

    public void placeOrder() {
        click(placeOrderBtn);
    }
}
