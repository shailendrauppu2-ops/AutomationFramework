package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends Abstraction {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".col-lg-4")
    List<WebElement> products;

    @FindBy(css = "button[routerlink='/dashboard/cart']")
    WebElement cartButton;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By toast = By.cssSelector("#toast-container");
    By addToCartBtn = By.cssSelector(".card-body button:last-of-type");

    public WebElement getProductByName(String name) {

        return products.stream()
                .filter(p -> p.findElement(By.cssSelector("b")).getText().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(String name) {
        WebElement product = getProductByName(name);
        product.findElement(addToCartBtn).click();

        waitForElement(toast);
        waitForDisappear(spinner);
    }

    public void goToCart() {
        click(cartButton);
    }
}
