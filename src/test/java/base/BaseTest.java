package base;

import com.codeborne.selenide.Configuration;
import config.ConfigManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {

        // ✅ Basic config
        Configuration.browser = ConfigManager.get("browser");
        Configuration.baseUrl = ConfigManager.get("base.url");
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.savePageSource = true;

        // 🔥 IMPORTANT — HEADLESS FOR CI
        String env = System.getProperty("env", "local");

        if (env.equals("ci")) {
            Configuration.headless = true;
            Configuration.browserSize = "1920x1080";
        } else {
            Configuration.headless = false;
        }

        // ✅ Chrome options
        ChromeOptions options = new ChromeOptions();

        // 🔥 CI-safe options
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 🔹 Local stability
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        // 🔹 Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        Configuration.browserCapabilities = options;

        // ✅ Open app
        open("/");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}