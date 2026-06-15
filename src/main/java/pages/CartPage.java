package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    private SelenideElement cartTitle = $(".title");
    private ElementsCollection cartItems = $$(".cart_item");
    private SelenideElement checkoutBtn = $("#checkout");

    // ✅ Verify cart page loaded
    public boolean isCartPageLoaded() {
        return cartTitle.shouldBe(visible)
                .getText()
                .equals("Your Cart");
    }

    // ✅ Get number of items in cart
    public int getCartItemsCount() {
        return cartItems.shouldHave(sizeGreaterThan(0)).size();
    }

    // ✅ Remove first item from cart
    public void removeFirstItem() {
        cartItems.first()
                .$("button")
                .shouldBe(visible)
                .click();
    }

    // ✅ Check item exists inside cart
    public boolean isItemPresent(String itemName) {
        return cartItems
                .findBy(text(itemName))
                .shouldBe(visible)
                .exists();
    }

    // 🔥 IMPROVED — safer checkout click
    public void clickCheckout() {
        checkoutBtn.shouldBe(visible, enabled).click();
    }

    // 🔥 NEW — validate cart is NOT empty (useful in E2E)
    public boolean isCartNotEmpty() {
        return cartItems.size() > 0;
    }
}