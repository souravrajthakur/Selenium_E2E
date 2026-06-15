package tests.cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest {

    private InventoryPage loginAndGoToInventory() {
        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("standard_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        return new InventoryPage();
    }

    // ✅ TC_CART_01
    @Test
    public void addMultipleItemsToCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.addItemByIndex(1);

        Assert.assertEquals(inventory.getCartCount(), 2,
                "Cart count mismatch");
    }

    // ✅ TC_CART_02
    @Test
    public void navigateToCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.clickCart();

        CartPage cart = new CartPage();

        Assert.assertTrue(cart.isCartPageLoaded(),
                "Cart page not loaded");
    }

    // ✅ TC_CART_03
    @Test
    public void verifyItemsInCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.addItemByIndex(1);

        inventory.clickCart();

        CartPage cart = new CartPage();

        Assert.assertEquals(cart.getCartItemsCount(), 2,
                "Items not present in cart");
    }

    // ✅ TC_CART_04
    @Test
    public void removeItemFromCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.addItemByIndex(0);
        inventory.addItemByIndex(1);

        inventory.clickCart();

        CartPage cart = new CartPage();

        cart.removeFirstItem();

        Assert.assertEquals(cart.getCartItemsCount(), 1,
                "Item not removed properly");
    }
}