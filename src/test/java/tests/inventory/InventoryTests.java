package tests.inventory;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {

    // 🔐 Common Login Step
    private InventoryPage loginAndGoToInventory() {
        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("standard_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        return new InventoryPage();
    }

    // ✅ TC_INV_01 - Verify inventory page loaded
    @Test
    public void verifyInventoryPageLoaded() {
        InventoryPage inventory = loginAndGoToInventory();

        Assert.assertTrue(inventory.isInventoryPageLoaded(),
                "Inventory page not loaded");
    }

    // ✅ TC_INV_02 - Add item to cart
    @Test
    public void addItemToCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.addFirstItemToCart();

        Assert.assertEquals(inventory.getCartCount(), 1,
                "Cart count mismatch after adding item");
    }

    // ✅ TC_INV_03 - Remove item from cart
    @Test
    public void removeItemFromCartTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.addFirstItemToCart();
        inventory.removeFirstItem();

        Assert.assertEquals(inventory.getCartCount(), 0,
                "Cart not empty after removal");
    }

    // ⭐ TC_INV_04 - Sorting validation (IMPORTANT)
    @Test
    public void sortLowToHighTest() {
        InventoryPage inventory = loginAndGoToInventory();

        inventory.sortLowToHigh();

        Assert.assertTrue(inventory.isSortedLowToHigh(),
                "Products are not sorted correctly (Low to High)");
    }
}