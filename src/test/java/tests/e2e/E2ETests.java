package tests.e2e;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class E2ETests extends BaseTest {

    @Test
    public void completePurchaseFlow() {

        // Login
        new LoginPage()
                .openPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        // Inventory → Add product
        InventoryPage inventory = new InventoryPage();
        inventory.addProductToCart("Sauce Labs Backpack");
        inventory.goToCart();

        // Cart → Checkout
        CartPage cart = new CartPage();
        cart.clickCheckout();

        // Checkout
        CheckoutPage checkout = new CheckoutPage();
        checkout.enterDetails("John", "Doe", "560001");
        checkout.finishCheckout();

        // Assertion
        Assert.assertTrue(checkout.getSuccessMessage().contains("Thank you"),
                "Order was not successful");
    }
}