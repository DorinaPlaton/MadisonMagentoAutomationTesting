import helper.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    WebDriverWait wait;

    @Before
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.getLoginPage();
        loginPage.insertEmailAddress(Constants.email);
        loginPage.insertPassword(Constants.password);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
        Assert.assertEquals("Hello, Andreea Antonia!", loginPage.getWelcomeMessage());
    }

    @Test
    public void loginWithoutEmail() {
        loginPage.getLoginPage();
        loginPage.insertPassword(Constants.password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals("This is a required field.", loginPage.getEmailFieldError());
    }
}
