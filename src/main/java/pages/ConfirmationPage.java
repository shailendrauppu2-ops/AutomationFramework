package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends Abstraction {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hero-primary")
    WebElement confirmationText;

    @FindBy(css = "label.ng-star-inserted")
    WebElement orderId;

    public String getConfirmationMessage() {
        return confirmationText.getText();
    }

    public String getOrderId() {
        return orderId.getText();
    }
}
