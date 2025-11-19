package User;

import Utils.PropertyReader;

public class UserFactory {
    public static User standardUser() {
        return new User(PropertyReader.getProperty("saucedemo.user"), PropertyReader.getProperty("saucedemo.password"));
    }

    public static User lockedUser() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"), PropertyReader.getProperty("saucedemo.password"));
    }

    public static User emptyUser() {
        return new User(PropertyReader.getProperty("saucedemo.empty_user"), PropertyReader.getProperty("saucedemo.password"));
    }

    public static User emptyPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"), PropertyReader.getProperty("saucedemo.empty_password"));
    }

    public static User incorrectPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"), PropertyReader.getProperty("saucedemo.incorrect_password"));
    }
}
