package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import dataproviders.LoginDataProvider;

import static com.codeborne.selenide.Selenide.$;

public class LoginTests extends BaseTest {

    // ✅ TC_LOGIN_01 - Valid Login
    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("standard_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        Assert.assertTrue(login.isLoginSuccessful(),
                "Login failed - Inventory page not visible");
    }

    // ❌ TC_LOGIN_02 - Invalid Login
    @Test
    public void invalidLoginTest() {

        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("invalid_user")
             .enterPassword("wrong_pass")
             .clickLogin();

        String error = login.getErrorMessage().toLowerCase();
        System.out.println("Error: " + error);

        Assert.assertTrue(error.contains("username and password"),
                "Error message not displayed correctly");
    }

    // 🚫 TC_LOGIN_03 - Locked User
    @Test
    public void lockedUserTest() {

        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("locked_out_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        String error = login.getErrorMessage().toLowerCase();
        System.out.println("Error: " + error);

        Assert.assertTrue(error.contains("locked out"),
                "Locked user error not shown");
    }

    // ⚡ TC_LOGIN_04 - Performance User
    @Test
    public void performanceUserTest() {

        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername("performance_glitch_user")
             .enterPassword("secret_sauce")
             .clickLogin();

        Assert.assertTrue(login.isLoginSuccessful(),
                "Performance user login failed");
    }

    // 🚀 TC_LOGIN_05 — Data Driven Login Test
    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginWithMultipleUsers(String username, String password) {

        System.out.println("Running test with: " + username);

        LoginPage login = new LoginPage();

        login.openPage()
             .enterUsername(username)
             .enterPassword(password)
             .clickLogin();

        String error = "";
        if (!login.isLoginSuccessful()) {
            error = login.getErrorMessage().toLowerCase();
            System.out.println("Error: " + error);
        }

        // 🔥 Strong validation logic
        if (username.equals("locked_out_user")) {

            Assert.assertTrue(error.contains("locked out"),
                    "Expected locked user error not shown");

        } else if (username.equals("invalid_user")) {

            Assert.assertTrue(error.contains("username and password"),
                    "Expected invalid login error not shown");

        } else {

            Assert.assertTrue(login.isLoginSuccessful(),
                    "Valid login failed for: " + username);
        }
    }
}