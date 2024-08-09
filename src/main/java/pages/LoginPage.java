package pages;

import helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#pass")
    private WebElement passwordField;
    @FindBy(id = "send2")
    private WebElement loginButton;
    @FindBy(css = ".hello strong")
    private WebElement welcomeMessage;
    @FindBy(css = "#advice-required-entry-email")
    private WebElement emailFieldError;


    public void getLoginPage() {
        driver.get(Constants.URL + Constants.loginPath);
    }

    public void insertEmailAddress(String email) {
        emailField.sendKeys(email);
    }

    public void insertPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getWelcomeMessage() {
        String welcome = welcomeMessage.getText();
        System.out.println("Welcome page message is :" + welcome);
        return welcomeMessage.getText();
    }

    public String getEmailFieldError() {
        return emailFieldError.getText();
    }

}
