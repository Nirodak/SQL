package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AuthPage;
import page.VerifyPage;


import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    public void login() throws InterruptedException {
        AuthPage authPage = new AuthPage();
        authPage.login(DataHelper.getAuthInfo());
        Thread.sleep(1000);
    }

    @Test
    public void loginTest() throws SQLException, InterruptedException {
        val runner = new QueryRunner();
        VerifyPage verify = new VerifyPage();
        val verifyCodeBD = "SELECT * FROM auth_codes ORDER BY created DESC limit 1;";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app",
                        "app", "pass");
        ) {
            login();
            DataHelper.VerifyCode verifyCode = runner.query(conn, verifyCodeBD,
                    new BeanHandler<>(DataHelper.VerifyCode.class));

            verify.setCode(verifyCode.getCode());
            verify.checkAuth();
        }
    }
}
