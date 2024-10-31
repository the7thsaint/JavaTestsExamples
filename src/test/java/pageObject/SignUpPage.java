package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.testingisgood.contstants.ElementsVisibilityParameters;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    private static final SelenideElement emailInput = $(By.id("email"));
    private static final SelenideElement continueEmailButton = $(By.xpath(".//button[@data-continue-to='password-container']"));
    private static final SelenideElement invalidEmailErrorP = $(By.xpath(".//p[text()='Email is invalid or already taken']"));
    private static final SelenideElement welcomeTextSpan = $(By.xpath(".//span[text()='Welcome to GitHub!']"));

    public SignUpPage setDataFromEmailInput(String userEmail) {
        emailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    public SignUpPage isWelcomeTextDisplayed() {
        welcomeTextSpan.shouldBe(visible);
        return this;
    }

    public SignUpPage isContinueButtonEnabled(ElementsVisibilityParameters parameter) {
        switch (parameter) {
            case VISIBLE -> continueEmailButton.shouldBe(enabled);
            case HIDDEN -> continueEmailButton.shouldBe(disabled);
            default -> throw new IllegalArgumentException("Input correct data");
        }
        return this;
    }

    public SignUpPage isInvalidEmailErrorDisplayed(ElementsVisibilityParameters parameter) {
        switch (parameter) {
            case VISIBLE -> invalidEmailErrorP.shouldBe(visible);
            case HIDDEN -> invalidEmailErrorP.shouldNotBe(visible);
            default -> throw new IllegalArgumentException("Input correct data");
        }
        return this;
    }
}
