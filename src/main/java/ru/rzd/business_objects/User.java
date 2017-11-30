package ru.rzd.business_objects;

import ru.rzd.util.ConfigurationManager;

public class User {
    private static final String PASSWORD = ConfigurationManager.getProperty("user.password");
    private static final String LOGIN = ConfigurationManager.getProperty("user.login");

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getLogin() {
        return LOGIN;
    }
}
