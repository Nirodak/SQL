package test;
import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AuthPage;


import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void testLogin() {
        AuthPage authPage = new AuthPage();
        authPage.login(DataHelper.getAuthInfo());
        Configuration.holdBrowserOpen = true;
    }

}
