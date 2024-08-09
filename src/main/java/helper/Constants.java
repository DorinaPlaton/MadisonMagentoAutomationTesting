package helper;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants {
    public static String URL = "http://qa2magento.dev.evozon.com";
    public static String registerPath = "/customer/account/create/";
    public static String loginPath = "/customer/account/login";
    public static String email = "aa@gmail.com";
    public static String password = "happyIsland321";
    public static String firstName = "FirstName";
    public static String lastName = "LastName";
    public static String registerPassword = "anyPassword";

    public static String generateRandomEmail() {
        String randomName = RandomStringUtils.randomAlphabetic(8);
        return randomName.toLowerCase() + "@email.com";
    }
}