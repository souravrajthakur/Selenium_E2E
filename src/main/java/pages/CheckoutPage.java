package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage extends BasePage {

    private SelenideElement checkoutTitle = $(".title");
    private SelenideElement firstName = $("#first-name");
    private SelenideElement lastName = $("#last-name");
    private SelenideElement postalCode = $("#postal-code");
    private SelenideElement continueBtn = $("#continue");
    private SelenideElement finishBtn = $("#finish");
    private SelenideElement successMessage = $(".complete-header");

    // ✅ Verify checkout page loaded
    public boolean isCheckoutPageLoaded() {
        return checkoutTitle.shouldBe(visible)
                .getText()
                .equals("Checkout: Your Information");
    }

    // 🔥 UPDATED — name aligned with E2E
    public void enterDetails(String fName, String lName, String zip) {
        firstName.shouldBe(visible).setValue(fName);
        lastName.setValue(lName);
        postalCode.setValue(zip);
        continueBtn.shouldBe(enabled).click();
    }

    // 🔥 UPDATED — name aligned with E2E
    public void finishCheckout() {
        finishBtn.shouldBe(visible, enabled).click();
    }

    // ✅ Verify success message
    public String getSuccessMessage() {
        return successMessage.shouldBe(visible).getText();
    }
}