package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerifyCode {
        private String code;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
}