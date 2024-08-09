import helper.Constants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
 WebDriver driver;
 Constants constants = new Constants();
    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        driver.manage().window().maximize();

    }
    @After
    public void closeDriver() {
        driver.quit();
    }
}
