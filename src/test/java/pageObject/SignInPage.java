package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.testingisgood.contstants.ElementsVisibilityParameters;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private static final SelenideElement loginFieldInput = $(By.id("login_field"));
    private static final SelenideElement passwordFieldInput = $(By.id("password"));
    private static final SelenideElement signInInput = $(By.xpath(".//input[@value='Sign in']"));
    private static final SelenideElement errorMessage = $(By.xpath(".//div[contains(text(), 'Incorrect')]"));
    private static final SelenideElement signInTextH1 = $(By.xpath(".//h1[text()='Sign in to GitHub']"));

    public SignInPage signInOperation(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        pushSignInButton();
        return this;
    }

    public SignInPage fillLoginField(String login) {
        loginFieldInput.shouldBe(visible).setValue(login);
        return this;
    }

    public SignInPage fillPasswordField(String login) {
        passwordFieldInput.shouldBe(visible).setValue(login);
        return this;
    }

    public SignInPage pushSignInButton() {
        signInInput.shouldBe(visible).click();
        return this;
    }

    public SignInPage isSignInWelcomeTextDisplayed() {
        signInTextH1.shouldBe(visible);
        return this;
    }

    public SignInPage isErrorMessageDisplayed(ElementsVisibilityParameters state) {
        switch (state) {
            case VISIBLE -> errorMessage.shouldBe(visible);
            case HIDDEN -> errorMessage.shouldNotBe(visible);
            default -> throw new IllegalArgumentException("Input correct data");
        }
        return this;
    }
}
