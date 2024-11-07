package projectsConfiguration.uiConf;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static ru.testingisgood.Tools.PropertiesWorker.readProperties;

public class BaseUiTest {

    public static ChromeOptions chromeOptions;

    @BeforeAll
    public static void setUp() {
        chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage"); //uncomment this for disable browser visibility
        Configuration.baseUrl = readProperties().getProperty("baseUrl");
        Configuration.pageLoadTimeout = parseInt(readProperties().getProperty("timeout"));
        Configuration.timeout = parseInt(readProperties().getProperty("timeout"));
        Configuration.browserCapabilities = chromeOptions;
        Configuration.screenshots = parseBoolean(readProperties().getProperty("enableScreenshots"));
        Configuration.savePageSource = parseBoolean(readProperties().getProperty("enableSavePageSource"));
        Configuration.browser = readProperties().getProperty("browser");
        Configuration.browserSize = readProperties().getProperty("browserSize");
    }

    @AfterAll
    public static void clearData() {
        clearBrowserCookies();
    }
}
