package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage extends BasePage {

    private ElementsCollection productList = $$(".inventory_item");
    private SelenideElement cartBadge = $(".shopping_cart_badge");
    private SelenideElement sortDropdown = $(".product_sort_container");
    private ElementsCollection prices = $$(".inventory_item_price");

    // ✅ Verify page loaded
    public boolean isInventoryPageLoaded() {
        return productList.first().shouldBe(visible).exists();
    }

    // ✅ Add first product to cart
    public void addFirstItemToCart() {
        productList.first().$("button").click();
    }

    // ✅ Remove first product
    public void removeFirstItem() {
        productList.first().$("button").click();
    }

    // ✅ Add item by index
    public void addItemByIndex(int index) {
        productList.get(index).$("button").click();
    }

    // ✅ Click cart icon
    public void clickCart() {
        $(".shopping_cart_link").click();
    }

    // ✅ Get cart count
    public int getCartCount() {
        if (cartBadge.exists()) {
            return Integer.parseInt(cartBadge.getText());
        }
        return 0;
    }

    // ✅ Sort Low to High
    public void sortLowToHigh() {
        sortDropdown.selectOption("Price (low to high)");
    }

    // ✅ Get all prices
    public List<Double> getAllPrices() {
        List<Double> priceList = new ArrayList<>();

        for (SelenideElement price : prices) {
            String text = price.getText().replace("$", "");
            priceList.add(Double.parseDouble(text));
        }

        return priceList;
    }

    // ✅ Validate sorting
    public boolean isSortedLowToHigh() {
        List<Double> actual = getAllPrices();
        List<Double> sorted = new ArrayList<>(actual);

        Collections.sort(sorted);

        return actual.equals(sorted);
    }

    // 🔥 NEW — Add product by name (for E2E)
    public InventoryPage addProductToCart(String productName) {
        productList.findBy(text(productName))
                .$("button")
                .shouldBe(visible)
                .click();
        return this;
    }

    // 🔥 NEW — Go to cart (alias for clarity in E2E)
    public void goToCart() {
        clickCart();
    }
}