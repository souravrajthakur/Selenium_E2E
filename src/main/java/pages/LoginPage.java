package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private SelenideElement username = $("#user-name");
    private SelenideElement password = $("#password");
    private SelenideElement loginBtn = $("#login-button");
    private SelenideElement errorMsg = $("h3[data-test='error']");
    private SelenideElement inventoryList = $(".inventory_list");

    // ✅ Open Login Page
    public LoginPage openPage() {
        open("/");
        username.shouldBe(visible);
        return this;
    }

    // ✅ Enter Username
    public LoginPage enterUsername(String user) {
        username.shouldBe(visible).clear();
        username.setValue(user);
        return this;
    }

    // ✅ Enter Password
    public LoginPage enterPassword(String pass) {
        password.shouldBe(visible).clear();
        password.setValue(pass);
        return this;
    }

    // ✅ Click Login
    public LoginPage clickLogin() {
        loginBtn.shouldBe(enabled).click();
        return this;
    }

    // ✅ Get Error Message (SAFE + FLEXIBLE)
    public String getErrorMessage() {
        return errorMsg.shouldBe(visible).getText();
    }

    // ✅ Check if login successful (NO HARD WAIT)
    public boolean isLoginSuccessful() {
        return inventoryList.exists();
    }

    // ✅ Wait for successful login (use when needed)
    public boolean waitForSuccessfulLogin() {
        return inventoryList.shouldBe(visible).exists();
    }

    // ✅ Check if error is displayed (NEW)
    public boolean isErrorDisplayed() {
        return errorMsg.exists();
    }
}