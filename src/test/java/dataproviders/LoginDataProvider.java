package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"invalid_user", "wrong_pass"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }
}