package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class EcommerceTest extends BaseTest {

    @Test
    public void completeOrderFlow() {

        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        ConfirmationPage confirm = new ConfirmationPage(driver);

        login.login(ConfigReader.get("username"), ConfigReader.get("password"));

        products.addProduct(ConfigReader.get("productName"));
        products.goToCart();

        cart.checkout();

        checkout.fillDetails(ConfigReader.get("country"));
        checkout.placeOrder();

        Assert.assertEquals(confirm.getConfirmationMessage(), "THANKYOU FOR THE ORDER.");

        System.out.println("ORDER ID: " + confirm.getOrderId());
    }
}
