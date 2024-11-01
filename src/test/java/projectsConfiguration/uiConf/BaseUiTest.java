package projectsConfiguration.uiConf;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class BaseUiTest {

    public static ChromeOptions chromeOptions;

    @BeforeAll
    public static void setUp() {
        chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage"); //uncomment this for disable browser visibility
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 60000;
        Configuration.browserCapabilities = chromeOptions;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.browser = "chrome";
        Configuration.browserSize = "2100x1080";
    }

    @AfterAll
    public static void clearData() {
        clearBrowserCookies();
    }
}
