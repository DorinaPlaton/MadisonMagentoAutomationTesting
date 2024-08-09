package pages;

import helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailAddressField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmation")
    private WebElement confirmPasswordField;

    @FindBy(css = ".button[title = \"Register\"]")
    private WebElement registerButton;

    @FindBy(css = ".success-msg")
    private WebElement successMessageForRegister;

    @FindBy(id = "advice-required-entry-firstname")
    private WebElement registerFirstNameFieldError;

    @FindBy(id = "advice-required-entry-lastname")
    private WebElement registerLastNameFieldError;

    @FindBy(css = ".error-msg")
    private WebElement registerEmailFieldError;

    @FindBy(id = "advice-required-entry-password")
    private WebElement registerPasswordFieldError;

    @FindBy(id = "advice-required-entry-confirmation")
    private WebElement registerConfirmPasswordFieldError;

    @FindBy(id = "is_subscribed")
    private WebElement signUpNewsletterCheckbox;

    @FindBy(css = "div:nth-child(4) .col-2 .box-content")
    private WebElement newsletterSubscriptionConfirmationMessage;

    public void getRegisterPage() {
        driver.get(Constants.URL + Constants.registerPath);
    }

    public void fillFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public void fillLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void fillEmailAddressField(String email) {
        emailAddressField.sendKeys(email);
    }

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void fillConfirmPasswordField(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public WebElement getSuccessMessageForRegister() {
        return successMessageForRegister;
    }

    public void fillRegisterMandatoryFieldsExcept(WebElement fieldToSkip) {
        fillFirstNameField(Constants.firstName);
        fillLastNameField(Constants.lastName);
        fillEmailAddressField(Constants.generateRandomEmail());
        fillPasswordField(Constants.registerPassword);
        fillConfirmPasswordField(Constants.registerPassword);
        fieldToSkip.clear();

    }

    public String getRegisterFirstNameFieldError() {
        return registerFirstNameFieldError.getText();
    }

    public String getRegisterLastNameFieldError() {
        return registerLastNameFieldError.getText();
    }

    public String getRegisterEmailFieldError() {
        return registerEmailFieldError.getText();
    }

    public String getRegisterPasswordFieldError() {
        return registerPasswordFieldError.getText();
    }

    public String getRegisterConfirmPasswordFieldError() {
        return registerConfirmPasswordFieldError.getText();
    }

    public void registration() {
        getRegisterPage();
        fillFirstNameField(Constants.firstName);
        fillLastNameField(Constants.lastName);
        fillEmailAddressField(Constants.generateRandomEmail());
        fillPasswordField(Constants.registerPassword);
        fillConfirmPasswordField(Constants.registerPassword);
    }

    public void selectSignUpNewsletterCheckbox(){
        signUpNewsletterCheckbox.click();
    }

    public String getNewsletterSubscriptionConfirmationMessage() {
        return newsletterSubscriptionConfirmationMessage.getText();
    }


}

