package uiTests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObject.SignUpPage;
import projectsConfiguration.uiConf.BaseUiTest;

import static ru.testingisgood.contstants.ElementsVisibilityParameters.HIDDEN;
import static ru.testingisgood.contstants.ElementsVisibilityParameters.VISIBLE;
import static ru.testingisgood.contstants.GitHubPlatformPageLinks.SIGN_UP_PAGE;

public class SignInPageTestsParametrized extends BaseUiTest {

    @BeforeEach
    public void openPage() {
        Selenide.open(SIGN_UP_PAGE);
        new SignUpPage().isWelcomeTextDisplayed();
    }

    @ParameterizedTest(name = "Проверка отображения текста ошибки о невалидном значении в поле email ({0})")
    @ValueSource(strings = {"test@", "test@ya", "test@ta."})
    public void currentErrorMessageTextAfterInputInvalidEmail(String email) {
        new SignUpPage()
                .setDataFromEmailInput(email)
                .isInvalidEmailErrorDisplayed(VISIBLE)
                .isContinueButtonEnabled(HIDDEN);
    }
}
