package tests.checkout;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTests extends BaseTest {

    // 🔹 Reusable login method
    private InventoryPage loginAndGoToInventory() {
        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("standard_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        return new InventoryPage();
    }

    // ✅ TC_CHECKOUT_01 - Navigate to checkout
    @Test
    public void navigateToCheckoutTest() {

        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.clickCart();

        CartPage cart = new CartPage();
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage();

        Assert.assertTrue(checkout.isCheckoutPageLoaded(),
                "Checkout page not loaded");
    }

    // ✅ TC_CHECKOUT_02 - Enter user details
    @Test
    public void enterUserDetailsTest() {

        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.clickCart();

        CartPage cart = new CartPage();
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage();

        // 🔥 FIXED METHOD NAME
        checkout.enterDetails("John", "Doe", "560001");

        // Better validation
        Assert.assertTrue(checkout.isCheckoutPageLoaded(),
                "Failed to proceed after entering details");
    }

    // ✅ TC_CHECKOUT_03 - Complete order
    @Test
    public void completeOrderTest() {

        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.clickCart();

        CartPage cart = new CartPage();
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage();

        checkout.enterDetails("John", "Doe", "560001");
        checkout.finishCheckout();

        Assert.assertTrue(
                checkout.getSuccessMessage().contains("Thank you"),
                "Order not completed successfully"
        );
    }
}