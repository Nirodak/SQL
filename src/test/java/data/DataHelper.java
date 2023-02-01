package data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


public class DataHelper {

    @Value
    @Builder(toBuilder = true)
    @AllArgsConstructor
    public static class AuthInfo {
        private String login;
        private String password;
    }
    public static AuthInfo getAuthInfo() {return new AuthInfo("vasya", "qwerty123");}
}