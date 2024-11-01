package uiTests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SignInPage;
import projectsConfiguration.uiConf.BaseUiTest;

import static ru.testingisgood.contstants.ElementsVisibilityParameters.VISIBLE;
import static ru.testingisgood.contstants.GitHubPlatformPageLinks.SIGN_IN_PAGE;

public class SignInPageTests extends BaseUiTest {

    public static final String INVALID_USER_LOGIN = "test";
    public static final String INVALID_USER_PASSWORD = "root";

    @BeforeEach
    public void openPage() {
        Selenide.open(SIGN_IN_PAGE);
        new SignInPage().isSignInWelcomeTextDisplayed();
    }

    @Test
    @DisplayName("Проверка отображения ошибки при попытки авторизации с невалидной парой логин+пароль")
    public void checkErrorMessageDisplayedAfterAuthWithInvalidCredentials() {
        new SignInPage()
                .signInOperation(INVALID_USER_LOGIN, INVALID_USER_PASSWORD)
                .isErrorMessageDisplayed(VISIBLE);
    }
}
