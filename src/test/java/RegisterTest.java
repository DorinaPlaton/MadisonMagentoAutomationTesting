import helper.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.time.Duration;


public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    WebDriverWait wait;

    @Before
    public void SetupPageObject() {
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void registerWithValidCredentials() throws InterruptedException {
        registerPage.getRegisterPage();
        registerPage.fillFirstNameField("Ema");
        registerPage.fillLastNameField("Adam");
        registerPage.fillEmailAddressField(Constants.generateRandomEmail());
        registerPage.fillPasswordField("HelloPass123");
        registerPage.fillConfirmPasswordField("HelloPass123");
        registerPage.clickRegisterButton();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getSuccessMessageForRegister()));
        Assert.assertEquals("Thank you for registering with Madison Island.", registerPage.getSuccessMessageForRegister().getText());
    }


    @Test
    public void registerWithoutFillingFirstNameField() {
        registerPage.getRegisterPage();
        registerPage.fillRegisterMandatoryFieldsExcept(registerPage.getFirstNameField());
        registerPage.clickRegisterButton();
        Assert.assertEquals("This is a required field.", registerPage.getRegisterFirstNameFieldError());
    }

    @Test
    public void registerWithoutFillingLastNameField() {
        registerPage.getRegisterPage();
        registerPage.fillRegisterMandatoryFieldsExcept(registerPage.getLastNameField());
        registerPage.clickRegisterButton();
        Assert.assertEquals("This is a required field.", registerPage.getRegisterLastNameFieldError());
    }

    @Test
    public void registerWithoutFillingEmailAddressField() {
        registerPage.getRegisterPage();
        registerPage.fillRegisterMandatoryFieldsExcept(registerPage.getEmailAddressField());
        registerPage.clickRegisterButton();
        Assert.assertEquals("\"Email\" is a required value.", registerPage.getRegisterEmailFieldError());
    }

    @Test
    public void registerWithoutFillingPasswordField() {
        registerPage.getRegisterPage();
        registerPage.fillRegisterMandatoryFieldsExcept(registerPage.getPasswordField());
        registerPage.clickRegisterButton();
        Assert.assertEquals("This is a required field.", registerPage.getRegisterPasswordFieldError());
    }

    @Test
    public void registerWithoutFillingConfirmPasswordField() {
        registerPage.getRegisterPage();
        registerPage.fillRegisterMandatoryFieldsExcept(registerPage.getConfirmPasswordField());
        registerPage.clickRegisterButton();
        Assert.assertEquals("This is a required field.", registerPage.getRegisterConfirmPasswordFieldError());
    }

    @Test
    public void registerAndSignUpForNewsletter() {
        registerPage.registration();
        registerPage.selectSignUpNewsletterCheckbox();
        registerPage.clickRegisterButton();
        Assert.assertEquals("Thank you for registering with Madison Island.", registerPage.getSuccessMessageForRegister().getText());
        Assert.assertEquals("You are currently subscribed to 'General Subscription'.", registerPage.getNewsletterSubscriptionConfirmationMessage());
    }

}

