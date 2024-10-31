package uiTests;

import com.codeborne.selenide.Selenide;
import config.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SignUpPage;

import static ru.testingisgood.contstants.ElementsVisibilityParameters.HIDDEN;
import static ru.testingisgood.contstants.ElementsVisibilityParameters.VISIBLE;
import static ru.testingisgood.contstants.GitHubPlatformPageLinks.SIGN_UP_PAGE;

public class SignUpPageTests extends BaseUiTest {

    public static final String validUserEmail = "tester112344@ya.ru";

    @BeforeEach
    public void openPage() {
        Selenide.open(SIGN_UP_PAGE);
        new SignUpPage().isWelcomeTextDisplayed();
    }

    @Test
    @DisplayName("Проверка активации кнопки Continue при валидном значении в поле email")
    public void checkContinueButtonIsEnabledAfterInputValidDataInEmail() {
        new SignUpPage()
                .setDataFromEmailInput(validUserEmail)
                .isInvalidEmailErrorDisplayed(HIDDEN)
                .isContinueButtonEnabled(VISIBLE);
    }
}
