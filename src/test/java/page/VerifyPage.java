package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerifyPage {
    private SelenideElement verifyCodeSelector = $("[data-test-id=code] input");
    private SelenideElement verifyButtonSelector = $("[data-test-id=action-verify]");
    private SelenideElement checkAuthSelector = $("[data-test-id=dashboard]");

    public void setCode(String code) {
        verifyCodeSelector.setValue(code);
        verifyButtonSelector.click();

    }

    public void checkAuth() {
        checkAuthSelector.shouldBe(visible);
    }

}
